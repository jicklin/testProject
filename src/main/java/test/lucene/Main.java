package test.lucene;

import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.document.Field;
import org.apache.lucene.document.StringField;
import org.apache.lucene.document.TextField;
import org.apache.lucene.index.*;
import org.apache.lucene.queryparser.classic.QueryParser;
import org.apache.lucene.search.*;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.FSDirectory;
import org.junit.Test;

import java.nio.file.*;

public class Main {

	@Test
	public void createIndexDB() {

		Article article = new Article(1, "the progress for learn java", "Jick 你好 Hello");
		Article article2 = new Article(2, "java life", "我是第二个");

		Document document = new Document();

		document.add(new StringField("xid", article.getId().toString(), Field.Store.YES));
		document.add(new StringField("xtitle", article.getTitle(), Field.Store.YES));
		document.add(new TextField("xcontent", article.getContent(), Field.Store.YES));
		Document document2 = new Document();
		document2.add(new StringField("xid", article2.getId().toString(), Field.Store.YES));
		document2.add(new StringField("xtitle", article2.getTitle(), Field.Store.YES));
		document2.add(new TextField("xcontent", article2.getContent(), Field.Store.YES));


		try (Directory directory = FSDirectory.open(Paths.get("F:\\lucene", "IndexDB2"))) {
			Analyzer analyzer = new StandardAnalyzer();
			IndexWriterConfig config = new IndexWriterConfig(analyzer);

			IndexWriter indexWriter = new IndexWriter(directory, config);

			long l = indexWriter.addDocument(document);
			 l = indexWriter.addDocument(document2);
			indexWriter.close();

		} catch (Exception e) {
			e.printStackTrace();

		}
	}

	@Test
	public void findIndexDB() {
		String key = "Hello";
		try (FSDirectory directory = FSDirectory.open(Paths.get("F:\\lucene", "IndexDB2"))) {
			StandardAnalyzer analyzer = new StandardAnalyzer();
			QueryParser queryParser = new QueryParser("xcontent", analyzer);
			Query query = queryParser.parse(key);
			System.out.println(query.toString());
//			Query query = new TermQuery(new Term("xtitle", "this"));

			IndexSearcher indexSearcher = new IndexSearcher(DirectoryReader.open(directory));
			int max_record = 100;
			TopDocs topDocs = indexSearcher.search(query, max_record);
			for (ScoreDoc scoreDoc : topDocs.scoreDocs) {
				Document doc = indexSearcher.doc(scoreDoc.doc);
				String xid = doc.get("xid");
				String xtitle = doc.get("xtitle");
				String xcontent = doc.get("xcontent");

				System.out.println(String.format("查询出来了，xid=%s ,xtitle = %s , xcontent = %s", xid, xtitle, xcontent));

			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}

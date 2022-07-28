package test.zk;

import org.apache.zookeeper.KeeperException;
import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.ZooKeeper;
import org.apache.zookeeper.data.Stat;

import java.io.IOException;
import java.util.concurrent.CountDownLatch;

public class ZookeeperProSync implements Watcher {

	private static CountDownLatch connectedSemaphore = new CountDownLatch(1);

	private static ZooKeeper zk = null;

	private static Stat stat = new Stat();

	@Override
	public void process(WatchedEvent watchedEvent) {
		// zk连接成功状态
		if (Event.KeeperState.SyncConnected == watchedEvent.getState()) {
			if (Event.EventType.None == watchedEvent.getType() && null == watchedEvent.getPath()) {
				connectedSemaphore.countDown();
			} else if (watchedEvent.getType() == Event.EventType.NodeDataChanged) {
				try {
					System.out.println("配置已修改，新值为：" + new String(zk.getData(watchedEvent.getPath(), true, stat)));
				} catch (KeeperException e) {
					e.printStackTrace();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}

			}

		}

	}

	public static void main(String[] args) throws Exception {
		//zookeeper配置数据存放路径
		String path = "/username";
		//连接zookeeper并且注册一个默认的监听器
		zk = new ZooKeeper("127.0.0.1:2181", 5000, //
				new ZookeeperProSync());
		//等待zk连接成功的通知
		connectedSemaphore.await();
		//获取path目录节点的配置数据，并注册默认的监听器
		System.out.println(new String(zk.getData(path, true, stat)));

		//Thread.sleep(Integer.MAX_VALUE);

	}
}

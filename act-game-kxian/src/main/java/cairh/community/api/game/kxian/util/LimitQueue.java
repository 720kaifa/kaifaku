package cairh.community.api.game.kxian.util;
import java.util.LinkedList;
import java.util.Queue;
/**
 * 固定长度队列
 */
public class LimitQueue<E> {
	
	
	Queue<E>  queue=new LinkedList<E>();
	
	//队列长度
	private int limit;
	
	
	public LimitQueue(int limit){
		this.limit = limit;
	}
	
	
	/**
	 * 入队
	 * @param e
	 */
	public boolean offer(E e){
		if(queue.size() >= limit){
			queue.poll();
		}
		return queue.offer(e);
	}
	
	/**
	 * 出队
	 * @return
	 */
	public E poll() {
		return queue.poll();
	}
	
	
	/**
	 * @param e
	 * @return
	 */
	public boolean offerHasPoll(E e){
		boolean hasPoll=false;
		if(queue.size() >= limit){
			hasPoll = true;
			queue.poll();
		}
		queue.offer(e);
		return hasPoll;
	}
	
}


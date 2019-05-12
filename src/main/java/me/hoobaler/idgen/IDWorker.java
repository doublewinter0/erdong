package me.hoobaler.idgen;

import org.joda.time.DateTime;

import java.util.LinkedHashSet;
import java.util.Set;

/**
 * @author erdong
 * @description 雪花 id
 * @date 17:18 2019/5/5
 **/
public class IDWorker {

	private static final long TWEPOCH;

	static {
		DateTime dateTime = new DateTime(
				2019,
				1,
				1,
				0,
				0,
				0,
				0
		);
		TWEPOCH = dateTime.getMillis();
	}

	private long count = 0;

	private long workerId;
	private long datacenterId;
	private long sequence = 0;
	/**
	 * 2018/9/29日，从此时开始计算，可以用到2089年
	 */


	private long workerIdBits = 5L;
	private long datacenterIdBits = 5L;
	private long sequenceBits = 12L;
	// 得到 0...0111111111111111
	private final long sequenceMask = ~(-1L << sequenceBits);
	private long workerIdShift = sequenceBits;
	private long datacenterIdShift = sequenceBits + workerIdBits;
	private long timestampLeftShift = sequenceBits + workerIdBits + datacenterIdBits;
	private long lastTimestamp = -1L;


	public IDWorker(long datacenterId, long workerId) {
		this.datacenterId = datacenterId;
		this.workerId = workerId;
	}

	public static void main(String[] args) {
		Set<Long> idSet = new LinkedHashSet<>();
		IDWorker worker = new IDWorker(1, 1);
		long begin = System.currentTimeMillis();
		for (int i = 0; i < 10000000; i++) {
			worker.nextId();
			// idSet.add(worker.nextId());
			// System.out.println(id);
		}
		System.out.println("time: " + (System.currentTimeMillis() - begin));
		System.out.println(worker.count);
		// System.out.println(idSet.size());
		// IOUtil.write2File(new File("idworker.txt"), idSet);
	}

	public synchronized long nextId() {
		long timestamp = timeGen();
		// 时间回拨，抛出异常
		if (timestamp < lastTimestamp) {
			System.err.printf("clock is moving backwards.  Rejecting requests until %d.", lastTimestamp);
			throw new RuntimeException(String.format("Clock moved backwards.  Refusing to generate id for %d milliseconds",
					lastTimestamp - timestamp));
		}

		if (timestamp == lastTimestamp) {
			sequence = (sequence + 1) & sequenceMask;
			// System.out.println("sequence = " + sequence);
			if (sequence == 0) {
				// System.out.println("sequence is 0");
				timestamp = tilNextMillis(lastTimestamp);
			}
		} else {
			// System.out.println(timestamp + " ---> " + lastTimestamp);
			count++;
			sequence = 0;
		}

		lastTimestamp = timestamp;
		return ((timestamp - TWEPOCH) << timestampLeftShift) |
				(datacenterId << datacenterIdShift) |
				(workerId << workerIdShift) |
				sequence;
	}

	private long tilNextMillis(long lastTimestamp) {
		long timestamp = timeGen();
		while (timestamp <= lastTimestamp) {
			timestamp = timeGen();
		}
		return timestamp;
	}

	private long timeGen() {
		return System.currentTimeMillis();
	}
}

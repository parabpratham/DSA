package study.os;

import java.util.Vector;

public class ProducerConsumerSolution {

	public static void main(String[] args) {
		ProducerConsumerSolution s = new ProducerConsumerSolution();
		Vector sharedQueue = new Vector();
		int size = 4;

		Thread consumerT = new Thread(s.new Consumer(sharedQueue, size),
				"Consumer");
		Thread producerT = new Thread(s.new Producer(sharedQueue, size),
				"producer");

		producerT.start();
		consumerT.start();
	}

	class Producer implements Runnable {

		private final Vector sharedQueue;
		private final int size;

		public Producer(Vector v, int size) {
			sharedQueue = v;
			this.size = size;
		}

		@Override
		public void run() {

			for (int i = 0; i < 10; i++) {
				System.out.println("Produced : " + i);
				try {
					produce(i);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}

		}

		private void produce(int i) throws InterruptedException {

			// wait till queue is full
			while (sharedQueue.size() == size) {
				synchronized (sharedQueue) {
					System.out.println("Queue is full");
					sharedQueue.wait();
				}

			}

			// producing element and notify others
			synchronized (sharedQueue) {
				sharedQueue.add(i);
				sharedQueue.notifyAll();
			}

		}

	}

	class Consumer implements Runnable {

		private final Vector sharedQueue;
		private int size;

		public Consumer(Vector v, int size) {
			this.size = size;
			sharedQueue = v;
		}

		public void run() {

			while (true) {
				try {
					System.out.println("Consumed : " + consume());
					Thread.sleep(50);

				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}

		}

		private int consume() throws InterruptedException {

			while (sharedQueue.size() == 0) {
				synchronized (sharedQueue) {

					System.out.println("Queues is empty "
							+ Thread.currentThread().getName());
					sharedQueue.wait();
				}
			}

			// consume
			synchronized (sharedQueue) {
				sharedQueue.notifyAll();
				return (Integer) sharedQueue.remove(0);

			}

		}
	}

}

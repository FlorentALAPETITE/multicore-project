package multithread;

import java.util.concurrent.Future;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import mandelbrot.Block;
import mandelbrot.BlockSettings;
import mandelbrot.Server;

import naive.NaiveBlock;


/**
 * Multithread implementation of Server
 */
public class MultithreadServer implements Server {

	ExecutorService threadPool;

	public MultithreadServer(int poolSize){
		threadPool = Executors.newFixedThreadPool(poolSize);
		
	}

	/**
	 * getBlock submit the computation of the Block to the ThreadPool
	 * @param bs All the data needed to build a new block
	 */
	public Future<Block> getBlock(BlockSettings bs){
		return threadPool.submit(new BlockComputation(bs));
	}
}

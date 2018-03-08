package multithread;

import java.util.concurrent.Callable;

import mandelbrot.Block;
import mandelbrot.BlockSettings;

public class BlockComputation implements Callable<Block> {

	Block block;

	public BlockComputation(BlockSettings bs){
		block = new Block(bs);
	}

	// Call the computation of the Block and return it
	public Block call(){
		block.compute();
		return block;
	}
	
}
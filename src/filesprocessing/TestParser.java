/*
package filesprocessing;

import filesprocessing.filters.*;
import filesprocessing.orders.*;
import org.junit.*;
import java.io.*;
import java.util.ArrayList;

public class TestParser {
	String filesDir = "C:/Users/Matan/IdeaProjects/ex5/Files";

	@Test
	public void oneFilterandOrder() {
		ArrayList<Subsection> res = Parser.parse(new File(filesDir + "/test.txt"));
		Filter filter = res.get(0).getFilterList().get(0);
		Assert.assertTrue(filter instanceof WritableFilter);
		Order order = res.get(0).getOrder();
		Assert.assertTrue(order instanceof SizeOrder);
	}

	@Test
	public void twoSubsections() {
		ArrayList<Subsection> res = Parser.parse(new File(filesDir + "/test.txt"));
		Filter filter = res.get(1).getFilterList().get(0);
		Assert.assertTrue(filter instanceof WritableFilter);
	}

	@Test
	public void twoFilters() {
		ArrayList<Subsection> res = Parser.parse(new File(filesDir + "/test1.txt"));
		Subsection subsect = res.get(0);
		Filter firstFilter = subsect.getFilterList().get(0);
		Filter secondFilter = subsect.getFilterList().get(1);
		Assert.assertTrue(firstFilter instanceof WritableFilter);
		Assert.assertTrue(secondFilter instanceof SmallerThanFilter);
	}
}
*/

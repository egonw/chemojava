/* $RCSfile$
 * $Author: mariobaseda $
 * $Date: 2007-01-03 17:57:14 +0100 (We, 03 Jan 2007) $
 * $Revision: 5602 $
 * 
 * Copyright (C) 2007 by Mario Baseda <mariobaseda@users.sourceforge.net>
 *
 * This program is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public License
 * as published by the Free Software Foundation; either version 2.1
 * of the License, or (at your option) any later version.
 * All we ask is that proper credit is given for our work, which includes
 * - but is not limited to - adding the above copyright notice to the beginning
 * of your source code files, and to any copyright notice that you may distribute
 * with programs based on this work.
 * 
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Lesser General Public License for more details.
 * 
 * You should have received a copy of the GNU Lesser General Public License
 * along with this program; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin St, Fifth Floor, Boston, MA 02110-1301 USA
 */
package org.openscience.chemojava.qsar.model.weka;

import org.junit.Assert;
import org.junit.Test;
import org.openscience.cdk.CDKTestCase;
import org.openscience.chemojava.libio.weka.Weka;

/**
 * TestSuite that runs a test for the EMCluster
 *
 * @author Mario Baseda
 * @cdk.module test-qsar
 */
public class EMClusterTest extends CDKTestCase{

	/**
	 * @throws Exception
	 */
	@Test public void testEMCluster() throws Exception{
//		String[] options = {"-N", "3"};
		EMCluster test = new EMCluster();
//		test.setOptions(options);
		int[] typAttrib = {Weka.NUMERIC, Weka.NUMERIC, Weka.NUMERIC};
		String[] classAttrib = {"A_", "B_", "C_"};
		double[][] x = {{10, 10, 10}, {10, -10, -10}, {-10, -10, -10},
				{11, 11, 11}, {11, -11, -11}, {-11, -11, -11}};
		Double[][] xD = new Double[x.length][x[0].length];
		for (int i = 0; i < xD.length; i++)
			for (int j = 0; j < xD[i].length; j++)
				xD[i][j] = new Double(x[i][j]);
		String[] y = {"A_", "B_", "C_", "A_", "B_", "C_"};
		String[] attrib = {"X1", "X2", "X3"};
		test.setData(attrib, typAttrib, classAttrib, y, xD);
		test.build();
		Double[][] newx = {
				{new Double(99), new Double(89), new Double(79)},
				{new Double(19), new Double(29), new Double(39)},
		};
		test.setParameters(newx);
		test.logDensityPerClusterForInstance();
		Assert.assertNotNull (test.clusterPriors());
		Assert.assertNotNull (test.getClusterModelsNumericAtts());
		Assert.assertNotNull (test.getClusterPriors());
		Assert.assertNotNull (test.getLogDensityPerClusterForInstance());
		Assert.assertNotNull (test.getClusterModelsNumericAtts());
		Assert.assertEquals(100, test.getSeed());
		Assert.assertEquals(-1, test.getNumClusters());
		Assert.assertEquals(1.0E-6, test.getMinStdDev(), 0.001);
		Assert.assertEquals(100, test.getMaxIterations());
		Assert.assertEquals(1, test.numberOfCluster());
	}

	/**
	 * @throws Exception
	 */
//	public void testEMCluster2() throws Exception{
//		EMCluster test = new EMCluster();
//		test.setData("X:\\cdk\\src\\data\\arff\\Table3.arff");
//		test.build();
//		test.setParameters("X:\\cdk\\src\\data\\arff\\Table4.arff");
//		test.logDensityPerClusterForInstance();
//		assertNotNull (test.clusterPriors());
//		assertNotNull (test.getClusterModelsNumericAtts());
//		assertNotNull (test.getClusterPriors());
//		assertNotNull (test.getLogDensityPerClusterForInstance());
//		assertNotNull (test.getClusterModelsNumericAtts());
//		assertEquals(100, test.getSeed());
//		assertEquals(-1, test.getNumClusters());
//		assertEquals(1.0E-6, test.getMinStdDev(), 0.001);
//		assertEquals(100, test.getMaxIterations());
//		assertEquals(1, test.numberOfCluster());
//	}
}

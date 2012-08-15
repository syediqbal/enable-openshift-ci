/*******************************************************************************
 * Copyright (c) 2012 Red Hat, Inc. Distributed under license by Red Hat, Inc.
 * All rights reserved. This program is made available under the terms of the
 * Eclipse Public License v1.0 which accompanies this distribution, and is
 * available at http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors: Red Hat, Inc. - initial API and implementation
 ******************************************************************************/
package com.openshift.client.example.enableci;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.concurrent.ExecutionException;

import com.beust.jcommander.ParameterException;
import com.openshift.client.OpenShiftException;

/**
 * @author Andre Dietisheim
 */
public class Main {

	public static void main(String[] argv) throws OpenShiftException, FileNotFoundException, IOException,
			InterruptedException, ExecutionException {
		Parameters parameters = new Parameters();
		try {
			parameters.parse(argv);
			OpenShiftCI ci = new OpenShiftCI(parameters.getUser(), parameters.getPassword());
			ci.create();
		} catch (ParameterException e) {
			System.out.println(e.getLocalizedMessage());
			System.out.println("Exiting...");
			parameters.usage();
		} catch (Exception e) {
			System.out.println(e.getLocalizedMessage());
			System.out.println("Exiting...");
		}
	}
}

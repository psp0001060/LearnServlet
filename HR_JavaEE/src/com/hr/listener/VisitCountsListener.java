package com.hr.listener;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class VisitCountsListener implements ServletContextListener{

	@Override
	public void contextInitialized(ServletContextEvent sce) {
		ServletContextListener.super.contextInitialized(sce);

		ServletContext sc = sce.getServletContext();
		String path = sc.getRealPath("/WEB-INF/classes");//固定写法
		File file = new File(path+"/com/hr/listener/visitcounts.txt");//只需要改变这里的路径
		BufferedReader br;
		int count = 0;
		try {
			br = new BufferedReader(new FileReader(file));
			count = Integer.valueOf(br.readLine());
			br.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		sc.setAttribute("guestLoginCount", count);
	}

	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		ServletContextListener.super.contextDestroyed(sce);
		ServletContext sc = sce.getServletContext();
		String path = sc.getRealPath("/WEB-INF/classes");//固定写法
		File file = new File(path+"/com/hr/listener/visitcounts.txt");//只需要改变这里的路径
		BufferedWriter bw;
		Integer count = Integer.valueOf(sc.getAttribute("guestLoginCount").toString());
		try {
			bw = new BufferedWriter(new FileWriter(file));
			bw.write(count.toString());
			bw.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	

}

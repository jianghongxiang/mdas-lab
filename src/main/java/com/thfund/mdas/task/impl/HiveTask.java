package com.thfund.mdas.task.impl;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import com.thfund.mdas.task.Task;

public class HiveTask implements Task {

  public String getName() {
    return "HiveTask";
  }

  public String getSchedulePattern() {
    return "* * * * *";
  }

  public void exec() throws Exception {
    Runtime r = Runtime.getRuntime();
    Process p = r.exec("hive -f "+" ../scripts/testHive.sql");
    BufferedReader bf = new BufferedReader(new InputStreamReader(p.getInputStream()));
    String line = "";
    while ((line = bf.readLine()) != null)
      System.out.println(line);
  }

}

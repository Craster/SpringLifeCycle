package com.example.springlifecycle.quoter;

public class ProfilingController implements ProfilingControllerMBean {
  private boolean enabled = true;

  public boolean isEnabled() {
    return enabled;
  }

  @Override
  public void setEnabled(boolean enabled) {
    this.enabled = enabled;
  }
}

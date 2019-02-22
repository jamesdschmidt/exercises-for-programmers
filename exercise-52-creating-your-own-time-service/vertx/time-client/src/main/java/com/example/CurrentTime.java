package com.example;

import java.time.Instant;

public class CurrentTime {
  private Instant currentTime;

  public Instant getCurrentTime() {
    return currentTime;
  }

  public void setCurrentTime(Instant currentTime) {
    this.currentTime = currentTime;
  }
}

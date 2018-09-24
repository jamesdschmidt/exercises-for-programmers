package com.example.timeclient;

import lombok.Data;

import java.time.Instant;

@Data
public class CurrentTime {
  private Instant currentTime;
}

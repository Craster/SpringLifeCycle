package com.example.springlifecycle.quoter;

import com.example.springlifecycle.quoter.annotations.DeprecatedClass;
import com.example.springlifecycle.quoter.annotations.InjectRandomInt;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
@Profiling
@DeprecatedClass(newImpl = Terminator2.class)
public class TerminatorQuoter implements Quoter {

  @InjectRandomInt(min = 2, max = 7)
  private int repeat;

  private String message;

  public void setMessage(String message) {
    this.message = message;
  }

  public void setRepeat(int repeat) {
    this.repeat = repeat;
  }

  public TerminatorQuoter() {
    //repeat var is 0 on constructor
    System.out.println("Phase 1");
  }

  @PostConstruct
  public void init() {
    System.out.println("Phase 2");
    System.out.println("repeat = " + repeat);
  }

  @Override
  //@PostProxy
  public void sayQuote() {
    System.out.println("Phase 3");
    for (int i = 0; i < repeat; i++) {
      System.out.println("message = " + message);
    }
  }


}

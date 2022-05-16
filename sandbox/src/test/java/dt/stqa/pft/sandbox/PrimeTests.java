package dt.stqa.pft.sandbox;

import dt.stqa.pft.sanbox.Primes;
import org.testng.Assert;
import org.testng.annotations.Test;

public class PrimeTests {

  @Test
  public void testPrimeFast() {
    Assert.assertTrue(Primes.isPrime(Integer.MAX_VALUE));

  }

  @Test (enabled = false)
  public void testPrimeLong() {
    long n = Integer.MAX_VALUE;
    Assert.assertTrue(Primes.isPrime(Integer.MAX_VALUE));

  }
}

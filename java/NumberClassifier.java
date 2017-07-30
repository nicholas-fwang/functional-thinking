import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.lang.Math.sqrt;
import static java.util.stream.Collectors.toList;
import static java.util.stream.IntStream.range;

public class NumberClassifier {
  public static void main(String[] args) {
    int number = 6;
    System.out.println("----- OOP java -----");
    NumberClassifier_OOP oop = new NumberClassifier_OOP(number);
    System.out.println(number + " is perfect? " + oop.isPerfect());

    System.out.println("----- IMPORVED java -----");
    System.out.println(number + " is perfect? " +
      NumberClassifier_IMPROVED.isPerfect(number));

    System.out.println("----- FUNC java -----");
    System.out.println(number + " is perfect? " +
      NumberClassifier_FUNC.isPerfect(number));
  }
}

class NumberClassifier_OOP {
    private int _number;
    private Map<Integer, Integer> _cache;

    public NumberClassifier_OOP(int targetNumber) {
      _number = targetNumber;
      _cache = new HashMap<>();
    }

    public boolean isFactor(int potential) {
      return _number % potential == 0;
    }

    public Set<Integer> getFactors() {
      Set<Integer> factors = new HashSet<>();
      factors.add(1);
      factors.add(_number);
      for(int i=2; i<_number; i++) {
        if(isFactor(i)) factors.add(i);
      }
      return factors;
    }

    public int aliquotSum() {
      if(_cache.get(_number) == null) {
        int sum = 0;
        for(int i : getFactors()) {
          sum += i;
          _cache.put(_number, sum - _number);
        }
      }
      return _cache.get(_number);
    }

    public boolean isPerfect() {
      return aliquotSum() == _number;
    }

    public boolean isAbundant() {
      return aliquotSum() > _number;
    }

    public boolean isDeficient() {
      return aliquotSum() < _number;
    }
}

class NumberClassifier_IMPROVED {
  public static boolean isFactor(final int candidate, final int number) {
    return number % candidate == 0;
  }

  public static Set<Integer> factors(final int number) {
    Set<Integer> factors = new HashSet<>();
    factors.add(1);
    factors.add(number);
    for(int i=2; i<number; i++) {
      if(isFactor(i, number)) {
        factors.add(i);
      }
    }
    return factors;
  }

  public static int aliquotSum(final Collection<Integer> factors) {
    int sum = 0;
    int targetNumber = Collections.max(factors);
    for(int n : factors) {
      sum += n;
    }
    return sum - targetNumber;
  }

  public static boolean isPerfect(final int number) {
    return aliquotSum(factors(number)) == number;
  }

  public static boolean isAbundant(final int number) {
    return aliquotSum(factors(number)) > number;
  }

  public static boolean isDeficient(final int number) {
    return aliquotSum(factors(number)) < number;
  }
}

class NumberClassifier_FUNC {
  public static IntStream factorsOf(int number) {
    return range(1, number+1)
      .filter(potential -> number % potential == 0);
  }

  public static int aliquotSum(int number) {
    return factorsOf(number).sum() - number;
  }

  public static boolean isPerfect(int number) {
    return aliquotSum(number) == number;
  }

  public static boolean isAbundant(int number) {
    return aliquotSum(number) > number;
  }

  public static boolean isDeficient(int number) {
    return aliquotSum(number) < number;
  }
}

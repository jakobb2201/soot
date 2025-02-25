package soot;

/*-
 * #%L
 * Soot - a J*va Optimization Framework
 * %%
 * Copyright (C) 1997 - 1999 Raja Vallee-Rai
 * %%
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License as
 * published by the Free Software Foundation, either version 2.1 of the
 * License, or (at your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Lesser Public License for more details.
 * 
 * You should have received a copy of the GNU General Lesser Public
 * License along with this program.  If not, see
 * <http://www.gnu.org/licenses/lgpl-2.1.html>.
 * #L%
 */

import heros.solver.Pair;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

import soot.Singletons.Global;

/**
 * Caches array types.
 * 
 * @author Marc Miltenberger
 */
public class ArrayTypeCache {
  private final Map<Pair<Type, Integer>, ArrayType> cache = new HashMap<>();

  private final Function<Pair<Type, Integer>, ArrayType> mapping = new Function<Pair<Type, Integer>, ArrayType>() {

    @Override
    public ArrayType apply(Pair<Type, Integer> t) {
      final Type baseType = t.getO1();
      int numDimensions = t.getO2();
      final int orgDimensions = numDimensions;
      Type elementType = baseType;
      while (numDimensions > 0) {
        ArrayType ret = elementType.getArrayType();
        if (ret == null) {
          int n = orgDimensions - numDimensions + 1;
          if (n != orgDimensions) {
            ret = getArrayType(baseType, n);
          } else {
            ret = new ArrayType(baseType, n);
          }
          elementType.setArrayType(ret);
        }
        elementType = ret;
        numDimensions--;
      }

      return (ArrayType) elementType;

    }

  };

  public ArrayTypeCache(Global g) {
  }

  /**
   * Returns a potentially cached array type of the given dimensions
   * @param baseType the base type (array element type)
   * @param numDimensions the number of dimensions
   * @return the array type
   */
  //We are doing this synchronized now to ensure correctness:
  //Already creating a new ArrayType adds it to the type numberer, so we must not create
  //the same array type twice. Furthermore, the ConcurrentHashMap's computeIfAbsent
  //method does not allow the update of other keys in while a value is computed.
  public synchronized ArrayType getArrayType(Type baseType, int numDimensions) {
    Pair<Type, Integer> pairSearch = new Pair<>(baseType, numDimensions);
    ArrayType res = cache.get(pairSearch);
    if (res == null) {
      res = mapping.apply(pairSearch);
      cache.put(pairSearch, res);
    }

    return res;

  }

}

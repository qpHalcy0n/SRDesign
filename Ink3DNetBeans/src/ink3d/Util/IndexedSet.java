/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ink3d.Util;

import java.util.HashMap;
import java.util.LinkedHashSet;

/**
 *
 * @author Tim
 */
public class IndexedSet<T> {
    private int size;
    private LinkedHashSet<T> set;
    private HashMap<T, Integer> map;

    public IndexedSet() {
        this.set = new LinkedHashSet<T>();
        this.map = new HashMap<T, Integer>();
        this.size = 0;
    }

    public boolean add(T o) {
        boolean success = this.set.add(o);
        if(success) {
            this.map.put(o, this.size++);
        }
        return success;
    }

    public int getIndexOf(T o) {
        if(this.set.contains(o)) {
            return this.map.get(o);
        }
        return -1;
    }

    public T[] asArray(T[] a) {
        return this.set.toArray(a);
    }

    public boolean contains(T o) {
        return this.set.contains(o);
    }

    public int size() {
        return this.size;
    }

}

package lab9;

import java.util.Iterator;
import java.util.Set;
import java.util.HashSet;

/**
 * Implementation of interface Map61B with BST as core data structure.
 *
 * @author Your name here
 */
public class BSTMap<K extends Comparable<K>, V> implements Map61B<K, V> {

    private class Node {
        /* (K, V) pair stored in this Node. */
        private K key;
        private V value;

        /* Children of this Node. */
        private Node left;
        private Node right;

        private Node(K k, V v) {
            key = k;
            value = v;
        }

        private Node(K k, V v, int sz) {
            key = k;
            value = v;
            size = 1;
        }
    }

    private Node root; /* Root node of the tree. */
    private int size; /* The number of key-value pairs in the tree */

    /* Creates an empty BSTMap. */
    public BSTMap() {
        this.clear();
    }

    /* Removes all of the mappings from this map. */
    @Override
    public void clear() {
        root = null;
        size = 0;
    }

    /**
     * Returns the value mapped to by KEY in the subtree rooted in P.
     * or null if this map contains no mapping for the key.
     */
    private V getHelper(K key, Node p) {
        if (key == null)
            throw new IllegalArgumentException("key is null");
        if (p == null)
            return null;
        int cmp = key.compareTo(p.key);
        if (cmp < 0)
            return getHelper(key, p.left);
        else if (cmp > 0)
            return getHelper(key, p.right);
        else
            return p.value;
    }

    /**
     * Returns the value to which the specified key is mapped, or null if this
     * map contains no mapping for the key.
     */
    @Override
    public V get(K key) {
        return getHelper(key, root);
    }

    /**
     * Returns a BSTMap rooted in p with (KEY, VALUE) added as a key-value mapping.
     * Or if p is null, it returns a one node BSTMap containing (KEY, VALUE).
     */
    private Node putHelper(K key, V value, Node p) {
        if (key == null)
            throw new IllegalArgumentException("key is null");
        if (value == null)
            throw new IllegalArgumentException("value is null");
        if (p == null) {
            size++;
            return new Node(key, value);
        }
        int cmp = key.compareTo(p.key);

        if (cmp < 0)
            p.left = putHelper(key, value, p.left);
        if (cmp > 0)
            p.right = putHelper(key, value, p.right);
        if (cmp == 0)
            p.value = value;
        return p;

    }

    /**
     * Inserts the key KEY
     * If it is already present, updates value to be VALUE.
     */
    @Override
    public void put(K key, V value) {
        root = putHelper(key, value, root);
    }

    /* Returns the number of key-value mappings in this map. */
    @Override
    public int size() {
        return size;
    }

    //////////////// EVERYTHING BELOW THIS LINE IS OPTIONAL ////////////////

    /* Returns a Set view of the keys contained in this map. */
    @Override
    public Set<K> keySet() {
        Set<K> set = new HashSet<>();
        return keySetHelper(root, set);
    }

    private Set<K> keySetHelper(Node p, Set<K> keySet) {
        if (p == null) {
            return null;
        }
        keySet.add(p.key);
        keySetHelper(p.left, keySet);
        keySetHelper(p.right, keySet);
        return keySet;
    }

    /**
     * Removes KEY from the tree if present
     * returns VALUE removed,
     * null on failed removal.
     */
    @Override
    public V remove(K key) {
        return removeHelper(root, key);
    }

    private V removeHelper(Node p, K key) {
        if (p == null) {
            return null;
        }
        if (p.key.equals(key)) {
            V rek = p.value;
            p.value = null;
            return rek;
        }

        V left = removeHelper(p.left, key);
        V right = removeHelper(p.right, key);
        if (left == null)
            return right;
        return left;
    }

    /**
     * Removes the key-value entry for the specified key only if it is
     * currently mapped to the specified value. Returns the VALUE removed,
     * null on failed removal.
     **/
    @Override
    public V remove(K key, V value) {
        return two_removeHelper(root, key, value);
    }

    private V two_removeHelper(Node p, K key, V value) {
        if (p == null) {
            return null;
        }
        if (p.key.equals(key) && p.value.equals(value)) {
            V rev = p.value;
            p.value = null;
            return rev;
        }
        V left = two_removeHelper(p.left, key, value);
        V right = two_removeHelper(p.right, key, value);
        if (left == null) {
            return right;
        }
        return left;
    }

    @Override
    public Iterator<K> iterator() {
        return new Key_iteration();
    }

    private class Key_iteration implements Iterator<K> {

        @override
        public K next() {
            return null;
        }

        @Override
        public boolean hasNext() {
            throw new UnsupportedOperationException();
        }

    }
}

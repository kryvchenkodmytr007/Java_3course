package org.example.collection;

import java.util.*;

/**
 * Власна реалізація інтерфейсу List на основі масиву.
 * <p>
 * Відповідає варіанту:
 * C2 = 0 (List)
 * C3 = 0 (Масив, початкова ємність 15, збільшення на 30%).
 * </p>
 *
 * @param <E> тип елементів у колекції.
 * @author Kryvchenko Dmytro
 * @version 1.0
 */
public class ToyArrayList<E> implements List<E> {

    /** Початкова ємність масиву згідно з варіантом. */
    private static final int INITIAL_CAPACITY = 15;

    /** Відсоток збільшення ємності (30%). */
    private static final double GROWTH_FACTOR = 1.3;

    /** Масив для зберігання елементів. */
    private Object[] elementData;

    /** Кількість елементів у списку. */
    private int size;


    /**
     * Порожній конструктор.
     * Ініціалізує масив розміром 15 елементів.
     */
    public ToyArrayList() {
        this.elementData = new Object[INITIAL_CAPACITY];
        this.size = 0;
    }

    /**
     * Конструктор з одним елементом.
     *
     * @param element елемент, який додається при створенні.
     */
    public ToyArrayList(E element) {
        this();
        add(element);
    }

    /**
     * Конструктор, що приймає стандартну колекцію.
     *
     * @param c колекція, елементи якої будуть додані.
     */
    public ToyArrayList(Collection<? extends E> c) {
        this();
        addAll(c);
    }


    /**
     * Перевіряє ємність масиву і збільшує її при необхідності.
     * Реалізує логіку варіанту: збільшення на 30%.
     */
    private void ensureCapacity() {
        if (size >= elementData.length) {
            int oldCapacity = elementData.length;
            int newCapacity = (int) (oldCapacity * GROWTH_FACTOR);

            // Захист від випадку, коли 30% надто мало (наприклад, при 0 або 1)
            if (newCapacity <= oldCapacity) {
                newCapacity = oldCapacity + 1;
            }

            elementData = Arrays.copyOf(elementData, newCapacity);
        }
    }


    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean contains(Object o) {
        return indexOf(o) >= 0;
    }

    @Override
    public Iterator<E> iterator() {
        return new Itr();
    }

    @Override
    public Object[] toArray() {
        return Arrays.copyOf(elementData, size);
    }

    @Override
    @SuppressWarnings("unchecked")
    public <T> T[] toArray(T[] a) {
        if (a.length < size)
            return (T[]) Arrays.copyOf(elementData, size, a.getClass());
        System.arraycopy(elementData, 0, a, 0, size);
        if (a.length > size)
            a[size] = null;
        return a;
    }

    @Override
    public boolean add(E e) {
        ensureCapacity();
        elementData[size++] = e;
        return true;
    }

    @Override
    public boolean remove(Object o) {
        int index = indexOf(o);
        if (index >= 0) {
            remove(index);
            return true;
        }
        return false;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        for (Object e : c)
            if (!contains(e))
                return false;
        return true;
    }

    @Override
    public boolean addAll(Collection<? extends E> c) {
        if (c.isEmpty()) return false;
        for (E e : c) {
            add(e);
        }
        return true;
    }

    @Override
    public boolean addAll(int index, Collection<? extends E> c) {
        if (index < 0 || index > size) throw new IndexOutOfBoundsException();
        if (c.isEmpty()) return false;
        // Спрощена реалізація через вставку по одному
        int i = index;
        for (E e : c) {
            add(i++, e);
        }
        return true;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        boolean modified = false;
        for (Object e : c) {
            while (contains(e)) {
                remove(e);
                modified = true;
            }
        }
        return modified;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        boolean modified = false;
        for (int i = size - 1; i >= 0; i--) {
            if (!c.contains(elementData[i])) {
                remove(i);
                modified = true;
            }
        }
        return modified;
    }

    @Override
    public void clear() {
        for (int i = 0; i < size; i++)
            elementData[i] = null;
        size = 0;
    }

    @Override
    @SuppressWarnings("unchecked")
    public E get(int index) {
        checkIndex(index);
        return (E) elementData[index];
    }

    @Override
    @SuppressWarnings("unchecked")
    public E set(int index, E element) {
        checkIndex(index);
        E oldValue = (E) elementData[index];
        elementData[index] = element;
        return oldValue;
    }

    @Override
    public void add(int index, E element) {
        if (index < 0 || index > size) throw new IndexOutOfBoundsException();
        ensureCapacity();
        System.arraycopy(elementData, index, elementData, index + 1, size - index);
        elementData[index] = element;
        size++;
    }

    @Override
    @SuppressWarnings("unchecked")
    public E remove(int index) {
        checkIndex(index);
        E oldValue = (E) elementData[index];

        int numMoved = size - index - 1;
        if (numMoved > 0)
            System.arraycopy(elementData, index + 1, elementData, index, numMoved);

        elementData[--size] = null; // Дозволяємо GC очистити пам'ять
        return oldValue;
    }

    @Override
    public int indexOf(Object o) {
        if (o == null) {
            for (int i = 0; i < size; i++)
                if (elementData[i] == null) return i;
        } else {
            for (int i = 0; i < size; i++)
                if (o.equals(elementData[i])) return i;
        }
        return -1;
    }

    @Override
    public int lastIndexOf(Object o) {
        if (o == null) {
            for (int i = size - 1; i >= 0; i--)
                if (elementData[i] == null) return i;
        } else {
            for (int i = size - 1; i >= 0; i--)
                if (o.equals(elementData[i])) return i;
        }
        return -1;
    }

    @Override
    public ListIterator<E> listIterator() {
        return new ListItr(0);
    }

    @Override
    public ListIterator<E> listIterator(int index) {
        if (index < 0 || index > size) throw new IndexOutOfBoundsException();
        return new ListItr(index);
    }

    @Override
    public List<E> subList(int fromIndex, int toIndex) {
        if (fromIndex < 0 || toIndex > size || fromIndex > toIndex) throw new IndexOutOfBoundsException();
        // Повертаємо новий список, що містить копію елементів (для спрощення)
        ToyArrayList<E> sub = new ToyArrayList<>();
        for (int i = fromIndex; i < toIndex; i++) {
            sub.add(get(i));
        }
        return sub;
    }

    private void checkIndex(int index) {
        if (index < 0 || index >= size)
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
    }

    /** Реалізація простого ітератора. */
    private class Itr implements Iterator<E> {
        int cursor;       // index of next element to return
        int lastRet = -1; // index of last element returned; -1 if no such

        public boolean hasNext() {
            return cursor != size;
        }

        @SuppressWarnings("unchecked")
        public E next() {
            int i = cursor;
            if (i >= size) throw new NoSuchElementException();
            cursor = i + 1;
            return (E) elementData[lastRet = i];
        }

        public void remove() {
            if (lastRet < 0) throw new IllegalStateException();
            ToyArrayList.this.remove(lastRet);
            cursor = lastRet;
            lastRet = -1;
        }
    }

    /** Реалізація ListIterator. */
    private class ListItr extends Itr implements ListIterator<E> {
        ListItr(int index) {
            super();
            cursor = index;
        }

        public boolean hasPrevious() {
            return cursor != 0;
        }

        @SuppressWarnings("unchecked")
        public E previous() {
            int i = cursor - 1;
            if (i < 0) throw new NoSuchElementException();
            cursor = i;
            return (E) elementData[lastRet = i];
        }

        public int nextIndex() {
            return cursor;
        }

        public int previousIndex() {
            return cursor - 1;
        }

        public void set(E e) {
            if (lastRet < 0) throw new IllegalStateException();
            ToyArrayList.this.set(lastRet, e);
        }

        public void add(E e) {
            ToyArrayList.this.add(cursor++, e);
            lastRet = -1;
        }
    }
}
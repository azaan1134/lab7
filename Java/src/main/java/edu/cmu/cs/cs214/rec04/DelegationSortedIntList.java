package edu.cmu.cs.cs214.rec04;

/**
 * DelegationSortedIntList -- a variant of a SortedIntList that keeps
 * count of the number of attempted element insertions (not to be confused
 * with the current size, which goes down when an element is removed)
 * and exports an accessor (totalAdded) for this count.
 *
 * @author Nora Shoemaker
 *
 */

public class DelegationSortedIntList implements IntegerList {
    // Write your implementation below with API documentation
    private SortedIntList sortedIntList;
    private int totalAdded; // Хэдэн элемент нэмэгдсэн тоог хадгалах

    public DelegationSortedIntList() {
        this.sortedIntList = new SortedIntList(); // Жагсаалтыг шинэчилж эхлүүлэх
        this.totalAdded = 0; // Нэмэгдсэн элементүүдийн тоог 0-аар эхлүүлнэ
    }

    public boolean add(int num) {
        boolean result = sortedIntList.add(num);
        if (result) {
            totalAdded++;
        }
        return result;
    }

    public boolean addAll (IntegerList list){
        boolean result = false;
        for(int i = 0; i < list.size(); i++){
            int element = list.get(i);
            if(add(element)){
                result = true;
            }
        }
        return result;
    }

    public int get(int index) {
        return sortedIntList.get(index); // Жагсаалтаас өгсөн индексийн элементийг авна
    }

    public boolean remove(int num) {
        boolean result = sortedIntList.remove(num);
        if (result) {
            totalAdded--; // Хэрвээ устгасан бол нэмэгдсэн тоог хасна
        }
        return result;
    }

    public boolean removeAll(IntegerList list) {
        boolean result = false;
        for (int i = 0; i < list.size(); i++) {
            int element = list.get(i);
            if(remove(element)){
                result = true;
            }        
        }
        return result;
    }

    public int size() {
        return sortedIntList.size(); // Жагсаалтын хэмжээ
    }

    public int getTotalAdded() {
        return totalAdded; // Нэмэгдсэн элементүүдийн нийт тоо
    }
}
package dataStructures.linkedList

data class LinkedListNode(
    var value: Int,
    var next: LinkedListNode? = null
)

class SinglyLinkedList {
    private var head: LinkedListNode? = null
    private var tail: LinkedListNode? = null
    private var size: Int = 0

    fun add(element: Int) {
        val nodeToBeAdded = LinkedListNode(element)
        if (head == null) {
            head = nodeToBeAdded
            tail = head
        } else {
            nodeToBeAdded.next = head
            head = nodeToBeAdded
        }
        size++
    }

    fun delete(element: Int){
        if(head == null) throw RuntimeException("The list is empty")

        if(size == 1 && head!!.value == element) {
            head = null
            size == 0
            return
        }

        var pointer: LinkedListNode? = head

        while (pointer!!.next != null){
            if(pointer.next!!.value == element) {
                pointer.next = pointer.next!!.next
                size--
                return
            }
            pointer = pointer.next
        }
    }

    fun contains(element: Int): Boolean {
        if(head == null) return false
        var pointer: LinkedListNode? = head
        while (pointer != null){
            if(pointer.value == element) return true
            pointer = pointer.next
        }
        return false
    }

    fun size() = size

    fun reverseListByValue() {
        var pointer: LinkedListNode? = head
        val valuesList = mutableListOf<Int>()
        while (pointer != null) {
            valuesList.add(pointer.value)
            pointer = pointer.next
        }

        pointer = head

        valuesList.asReversed().forEach { element ->
            pointer?.value = element
            pointer = pointer?.next
        }
    }

    fun reverseListByLinks() {
        var mainPointer: LinkedListNode? = head
        var leftPointer: LinkedListNode? = null
        var rightPointer: LinkedListNode? = null

        while (mainPointer != null) {
            rightPointer = mainPointer
            mainPointer = mainPointer.next

            rightPointer.next = leftPointer
            leftPointer = rightPointer
        }
        head = rightPointer
    }

    fun reverseListLinksUsingRecursion(pointer: LinkedListNode? = head): LinkedListNode {
        if (pointer?.next == null) {
            head = pointer
            return pointer!!
        }

        val nextNode = reverseListLinksUsingRecursion(pointer?.next)
        nextNode.next = pointer
        pointer.next = null
        return pointer
    }

    fun concatenate(list: LinkedListNode) {
        if (head == null) {
            head = list
            return
        }

        tail?.next = list

        var newTail = list

        while (newTail != null) {
            tail = newTail
            newTail = newTail.next!!
            size++
        }
    }

    fun merge(list: LinkedListNode){

    }

    fun print() {
        var pointer: LinkedListNode? = head

        while (pointer != null) {
            print(pointer.value)
            print(" ")
            pointer = pointer.next
        }
    }
}

fun main() {
    val linkedList = SinglyLinkedList()
    for (i in 1..100) {
        linkedList.add(i)
    }
    println("#### SIZE ####")
    println(linkedList.size())
    println("### LIST CONTENTS ###")
    linkedList.print()
    println("")
    linkedList.reverseListByValue()
    println("### REVERSED LIST ####")
    linkedList.print()
    println("")
    println("### REVERSE LIST BY LINKS ###")
    linkedList.reverseListByLinks()
    linkedList.print()
    println("")
    linkedList.reverseListLinksUsingRecursion()
    println("### REVERSE LIST USING RECURSION ####")
    linkedList.print()
    println("")
    println("### REMOVING NUMBER 43 ###")
    linkedList.delete(43)
    println("### SIZE AFTER REMOVING ###")
    println(linkedList.size())
    println("### CHECK IF LIST CONTAINS NUMBER 43 ###")
    println(linkedList.contains(43))
}
package dataStructures.tree

interface Tree<T> {
    fun add(element: T)

    fun remove(element: T)

     fun traverse(traverse: Traversals)

     fun print()
}
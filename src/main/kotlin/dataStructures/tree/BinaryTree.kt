package dataStructures.tree

class BinaryTree : Tree<Int>() {

    override fun add(element: Int) {
        tree.add(element)
    }

    override fun remove(element: Int) {
        TODO("Not yet implemented")
    }

    override fun traverse(traverse: Traversals) {
        traverse.exec(tree)
    }

}
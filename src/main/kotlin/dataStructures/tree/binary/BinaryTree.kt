package dataStructures.tree.binary

enum class TraverseMode {
    IN_ORDER,
    PRE_ORDER,
    POST_ORDER,
    DIAGONAL,
    BORDER
}

class BinaryTree {
    private var root: Node? = null
    fun add(element: Node) {
        if (root == null) {
            root = element
            return
        }

        var temp: Node = root!!

        while (true) {
            if (temp.value < element.value) {
                if (temp.right == null) {
                    temp.right = element
                    return
                }

                temp = temp.right!!
            } else {
                if (temp.left == null) {
                    temp.left = element
                    return
                }

                temp = temp.left!!
            }
        }
    }

    fun addByLevel(element: Node) {
        TODO()
    }

    fun remove(value: Int) {
        TODO("Not yet implemented")
    }

    fun traverse(traverseMode: TraverseMode) {
        when (traverseMode) {
            TraverseMode.IN_ORDER -> {
                println("###### PRINTING IN ORDER #####")
                if (root == null) return

                val stack = mutableListOf<Node>()
                var temp = root

                while (true) {
                    temp = if (temp == null) {
                        if (stack.isEmpty()) return
                        val curr = stack.removeLast()
                        println(curr.value)
                        curr.right
                    } else {
                        stack.add(temp)
                        temp.left
                    }
                }
            }

            TraverseMode.PRE_ORDER -> {
                println("##### PRINTING PRE ORDER #####")
                if (root == null) return

                val stack = mutableListOf<Node>()

                var temp = root

                while (true) {
                    temp = if (temp != null) {
                        println(temp.value)

                        temp.right?.let { stack.add(it) }
                        temp.left
                    } else {
                        if (stack.isEmpty()) return

                        val curr = stack.removeLast()
                        println(curr.value)

                        curr.right?.let { stack.add(it) }
                        curr.left
                    }
                }
            }

            TraverseMode.POST_ORDER -> {
                println("##### PRINTING POST ORDER #####")
                if (root == null) return
                val stack = mutableListOf<Node>()
                var temp = root
                 do {

                    if (temp == null) {
                        temp = stack.removeLast()

                        if (temp.right != null && temp.right == stack.lastOrNull()) {
                            val currRight = stack.removeLast()
                            stack.add(temp)

                            temp = if(currRight.right != null) {
                                stack.add(currRight.right!!)
                                stack.add(currRight)
                                currRight.left
                            } else if(currRight.left != null) {
                                stack.add(currRight)
                                currRight.left
                            } else {
                                println(currRight.value)
                                null
                            }
                        } else {
                            println(temp.value)
                            temp = null
                        }
                    } else {
                        temp.right?.let { stack.add(it) }
                        stack.add(temp)
                        temp = temp.left
                    }
                } while(stack.isNotEmpty())
            }

            TraverseMode.BORDER -> {}
            TraverseMode.DIAGONAL -> {}
        }
    }

}
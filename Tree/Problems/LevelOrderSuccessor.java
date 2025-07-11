public int BFSSuccessor(int value) {
    queue.offer(root);
    while (!queue.isEmpty()) {
        Node currentNode = queue.poll();
        if (currentNode.left != null) {
            queue.offer(currentNode.left);
        }
        if (currentNode.right != null) {
            queue.offer(currentNode.right);
        }
        if (currentNode.value == value && !queue.isEmpty()) {
            return queue.peek().value;
        }
    }

    return -1;
}
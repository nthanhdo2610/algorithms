Algorithm mergeSort(S,C)
	Input:sequence S with n elements, Comparator C.
	Ouput: Sequence S sorted according to C.
	
	if(S.size() > 1)
		S1 <- partition(S,0,n/2-1)
		S2 <- partition(S,n/2,n)
		mergeSort(S1,C)
		mergeSort(S2,C)
		S->merge(S1,S2)
		
Algorithm partition(S,i,j)
	Input:Sequence S with the position of start and end for making partition
	Output: Sequence S1 with the elements from i to j
	
	S1<-empty sequence
	while i <= j do
		S1.insertLast(S.elementAtRank(i))
		i <- i + 1
	return S1
	
Algorithm merge(A, B, C)
	Input:sequences A and B with n/2 elements each,comparator C 
	Output:sorted sequence of A U B
	
	S <- empty sequence
	while not A.isEmpty() ^ not B.isEmpty() do
		if C.isLessThan( B.first().element(),A.first().element() ) then
			S.insertLast(B.remove(B.first()))
		else
			S.insertLast(A.remove(A.first()))
		while not A.isEmpty() do
			S.insertLast(A.remove(A.first()))
		while not B.isEmpty() do
			S.insertLast(B.remove(B.first()))
	return S
=========================
Algorithm removeDuplicateAndUnion(A, B)
    Input:sequences A and B with n elements each
    Output:sorted sequence of A U B
    
    S <- empty sequence
    while !A.isEmpty() ^ !B.isEmpty() do
        if B.first().element() < A.first().element() then
            S.insertLast(B.remove(B.first()))
        else B.first().element() > A.first().element() then
            S.insertLast(A.remove(A.first()))
		else
			S.insertLast(A.remove(A.first()))
			B.remove(B.first())
    return S
=================
Algorithm electionWinner(S)
	Input: n-element sequence S where each element represent a different vote
	Ouput: ID of winning candidate
	mergeSort(S,C)
	winnerId <- S.first()
	maxVote <- 0
	previousId <- S.first()
	while !S.isEmpty() do
		currentId <- S.remove(S.first())
		if currentId != previousId then
			if maxVote < noOfVote
				maxVote <- noOfVote
				winnerId <- currentId
		else
			previousId <- currentId
			noOfVote<- noOfVote + 1
==================================================
Algorithm getSmallerEqualKey(T,x)
	Input: Vector based heap T, stroing n keys and query key x
	Ouput: Sequence S, containing all the keys which are less than or equal to x
	S <-empty sequence
	i<-1
	while i < T.size()
		key<-elementAtRank(i)
		if key <= x
			S.insertLast(key)
			i <- i + 1
		else
			return S
		
===================
Algorithm getSmallerEqualKey(T,key,i)
	Input: Vecotr T representing a Heap,index i of an element in the heap and a query key
	Output: Vecotr V contining all the keys which are less than or equal to given key
	if i < T.size() ^ T.elementAtRank(i) <= key
		V.insertLast(T.elementAtRank(i))
		getSmallerEqualKey(T,key,2 * i)
		getSmallerEqualKey(T,key,2 * i + 1)
		return
===================
Algorithm root()
	Output:position of the root of the tree T in vector S
	return 1
==========
Algorithm parent(p)
	Input : a position p of a node in the vector S
	Output:position of the root of the tree T in S
	return p / 2
=================
Algorithm leftChild(p)
	Input : a position p of a node in the vector S
	Output:position of the leftChild of the tree T in S
	return 2 * p
==========
Algorithm rightChild(p)
	Input : a position p of a node in the vector S
	Output:position of the leftChild of the tree T in S
	return 2 * p + 1
==========
Algorithm isInternal(p)
	Input : a position p of a node in the vector S
	Output:position of the leftChild of the tree T in S
	if 2 * p <= S.size() or (2 * p + 1) <= S.size()
		return true
	return false
=========================
Algorithm isExternal(p)
	Input : a position p of a node in the vector S
	Output:position of the leftChild of the tree T in S
	if 2 * p > S.size() ^ (2 * p + 1) > S.size()
		return true
	return false
===============
Algorithm putSequenceInRandomOrder(S)
	Input:Sequence S with n elements
	Output: S in random order
	r <- n - 1
	while r > 0 do
		rand <- randomInt(r)
		S.swapElements(S.atRank(r),S.atRank(rand))
		r <- r - 1
	return S
===================================
Algorithm insertBefore(p,e)
	Input : position of node p where  newnode will be inserted before this node and element of newNode
	Output: newNode with element e will be inserted into list.
	newNode<-createNewNode(e)
	tmp<-p.prev
	tmp.next <- newNode
	newNode.next <- p
	newNode.prev <- tmp
	p.prev <- newNode
=============
Algorithm findMiddle(L)
	Input : List L with odd number of nodes
	Output : middle position of L
	p<-L.first()
	q<-L.last()
	while p != q do 
		p<-L.after(p)
		q<-L.before(q)
	return p
	===========================
Algorithm insertFirst(e)
	Input : element e,which will be inserted into first of the linked list
	Output: newNode with element e will be inserted into first position of list.
	newNode<-createNewNode(e)
	tmp<-head.next
	head.next<-newNode
	newNode.next<-tmp
	tmp.prev <- newNode
	newNode.prev <- head
	====================
Algorithm insertLast(e)
	Input : element e,which will be inserted into last position of the linked list
	Output: newNode with element e will be inserted into last position of list.
	newNode<-createNewNode(e)
	tmp<-tail.prev
	tail.prev <-newNode
	newNode.prev<-tmp
	tmp.next <- newNode
	newNode.next <- tail
============================
Algorithm insertAtRank0(obj)
	Input: the object obj for inserting
	if V.size() = n-1
		throw fullException
	f<-(f - 1 + n ) mod n
	V[f] <- obj
============================
Algorithm insertAtRankEnd(obj)
	Input: the object obj for inserting
	if V.size() = n-1
		throw fullException
	V[r] <- obj
	r <- (r + 1) mod n
===================
Algorithm removeAtRank0()
	if !V.isEmpty()
		f<-(f + 1 ) mod n
	else
		throw emptyVectorException
====================
Algorithm removeAtRankEnd()
	if !V.isEmpty() then
		r<-(r - 1 + n) mod n
	else
		throw emptyVectorException
========================
S1<-Empty Stack
S2<-Empty Stack

enqueue(val)
	if size() = N - 1 then
		throw FullQueueException
	S1.push(val)
	
dequeue()
	if S2.isEmpty() then
		while !S1.isEmpty() do
			S2.push(S1.pop())
	if !S2.isEmpty() then
		return S2.pop()
	else
		throw EmptyStackException
=================================
Q1<-Empty Queue 
Q2<-Empty Queue

push(val)
	if size() = N - 1 then
		throw FullStackException
	Q1.enqueue(val)
pop()
	if Q2.isEmpty() then
		while !Q1.isEmpty()
			Q2.enqueue(Q1.dequeue())
	if !Q2.isEmpty() then
		Q2.dequeue()
	else
		throw EmptyQueueException
===========================
Algorithm perm(S, int n)
	Input: Sequence S with n elements
	Output: List L containing all the permutation
	
	if n = 1 then
		L.insertLast(S)
		return;
	while i < S.size() do
		S.swapElements(S.rankOf(i),S.rankOf(n-1))
		perm(S,n-1)
		S.swapElements(S.rankOf(i),S.rankOf(n-1))
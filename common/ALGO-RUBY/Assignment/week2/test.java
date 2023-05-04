Algorithm removeElement(x)
	Input: key x for remove item
	Output: item deletion with the key
	p<-first position top list
	p<-find(x,p)//return position of the key
	if p != NULL
		while p != NO_SUCH_KEY do 
			if p.before = MINUS_INF ^ p.after = PLUS_INF
				p.before.below.above <- NULL
				p.after.below.above <- NULL
			a<-p.below
			tmp <- p.before
			tmp.after = p.after
			p.after.before = tmp
			p<-a
	================
Algorithm find(x,p)
	Input:key x,postion p
	Output: postion of the key x
	y<-key(p.after)
	if x = y
		return p.after
	else if x > y then
		return find(x,p.after)
	else
		return find(x,p.below)
	return NULL
==================
Algorithm isExistTwoEqualElement(S)
	Input: Sequence S with n elements
	Output: true or false if two equal elements exis in the sequence,otherwise false
	D<-new Dictionary(HashTable)
	for each x of S do
		cnt <-D.findElement(x)
		if cnt != NO_SUCH_KEY then
			D.insertItem(x,0)
		else
			return true
	return false
====================

Algorithm inPlacePartition(S, lo, hi)
	Input: Sequence S and ranks lo and hi, 0 <= lo,hi < S.size()
	Output: Skip duplicate keys in the next partition
	
	p <-- a random integer between lo and hi 
	S.swapElements(S.atRank( lo ), S.atRank( p ))
	pivot <-- S.elemAtRank(lo) 
	j <-- lo + 1
	k <-- hi
	while  j < k  do
		while k >= j ^ S.elemAtRank(k) > pivot do
			k <-- k – 1 
		while j <= k ^ S.elemAtRank(j) < pivot do
			j <--  j + 1
		if  j < k  then
			S.swapElements(S.atRank( j ), S.atRank( k ))
	S.swapElements(S.atRank( lo ), S.atRank( k )) {move pivot to sorted rank}
	return k  
=========================

Algorithm countInversion(S, C) 
	Input : sequence S with total order n elements, comparator C 
	Output: number of Inversion
	
	if S.size() > 1 then 
		(S1, S2)<-partition(S, n/2) 
		countInversion(S1, C) 
		countInversion(S2, C) 
		(S,cnt) <-merge(S1, S2, C)
		count <- count + cnt
	return count

Algorithm merge(A, B, C) 
	Input: sequences A and B with n/2 elements each, comparator C
	Output: count of number of inversion
	count<-0
	S <- empty sequence 
	while !A.isEmpty() ^ !B.isEmpty() do 
		if C.isLessThan( B.first().element(), A.first().element() ) then 
			S.insertLast(B.remove(B.first())) 
			count <- count + 1
		else 
			S.insertLast(A.remove(A.first())) 
		while !A.isEmpty() do 
			S.insertLast(A.remove(A.first())) 
		while !B.isEmpty() do 
			S.insertLast(B.remove(B.first())) 
	return count,S
=====================
Pseudo-code FindAllInRange(k1, k2) 
	if k1 <= k2 then 
		throw exception k2 is bigger than k1

	node1 <-- findElement(k1)
	node2 <-- findElement(k2)

	if node1 == null or node2 == null then
		throw exception key not found

	List <-- new List
	insertToList(D.rightChild(node1), node2, D, List) 
	iterator <-- List.iterator()
	return iterator

Pseudo-code insertToList(node1, node2, Tree, List)
	if node1 < node2 && node1 != null then
		insertToList(Tree.leftChild(node1), node2, Tree, List)
		insertToList(Tree.rightChild(node1), node2, Tree, List)
		List.insertLast(Tree.items(node1))

==============
Algorithm findAllInRange(k1,k2)
	Input: key k1, k2
	Ouput: return iterator for all the elements in D within the range of k1 and k2
	T<- tree of D
	S<-findElements(T,T.root(),k1,k2)
	return S.iterator()
	
===================
Algorithm findElements(T,p,k1,k2)
	Input: Tree T, position of a node p, key k1, k2
	Output: Sequence S with all the elements between the range of k1 and k2 inclusive.
	S<-new Sequence
	k <- T.key(p)
	if k1 <= k ^ k <= k2 then
		S.insertLast(D.findElement(k))
		findElements(T,T.leftChild(p),k1,k2)
		findElements(T,T.rightChild(p),k1,k2)
	else if k < k1 then
		return findElements(T,T.leftChild(p),k1,k2)
	return S
	
====================
Algorithm electionWinner(S, C)
	Input: Sequence S of votes and Sequence SC of candidates
	Ouput:Id of winner candidate
	
	D<-new Dictionary(Hastable)
	for each id of C do
		D.insertItem(id,0)
	for each y of S do
		cnt<-D.findElement(x)
		D.insertItem(y,cnt + 1)
	winnerId <- -1
	for each (id,cnt) of D.items() do 
		if cnt > winnerId then
			winnerId<-id
			winnerCount<-cnt
	return winnerId
===================
Algorithm isSumEqual(A,B,x)
	Input: Two Sequence A, B and integer x
	Ouput: true or false if such two intergers of A and B makes x
	T <- insert A into Redblack tree
	for each y of B do
		if T.findElement(x-y) != NULL then 
			return true
	return false
===============
Algorithm isSameSetElements(A,B)
	Input: Sequence A, B
	Ouput: true if they are elements of same set,othewise false
	if A.size() = B.size() then 
		D1<- Dictionary(hastable)
		D2<- Dictionary(hastable)
		
		for each x of A do
			cnt<-D1.findElement(x)
			if cnt != NO_SUCH_KEY then
				D1.insertItem(x, cnt + 1)
			else
				D1.insertItem(x, 0)
		for each x of B do
			cnt<-D2.findElement(x)
			if cnt != NO_SUCH_KEY then
				D2.insertItem(x, cnt + 1)
			else
				D2.insertItem(x, 0)
		for each x of A do
			if D1.findElement(x) != D2.findElement(x) then
			return false
	return true
=================
Algorithm removalLinearProbing(key)
	Input: key to remove from 
	Output: remove and return the element
	
	key, element) <- findElement(key)
	If key != NO_SUCH_KEY then
		key <- AVAILABLE
		return element
	return NO_KEY_FOUND
===============

Algorithm nutsBoltsMatchup(A, B)
	Input : Sequence A of nuts, sequence B of bolts
	Output : Matched set of nuts and bolts
	
	T <- insertIntoRedBlackTree(B)
	PQ <- new Priority Queue Array
	for each x of A do
		PQ.insert(x, PQ.remove(x))
	return PQ
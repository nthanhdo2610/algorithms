13(2)
a.
Algorsithm BFS(G)
	Input graph G
	Output labeling of the edges and partition of the vertices of G
	initResult( G )
	for all u of G.vertices()
		setLabel(u, UNEXPLORED)
	for all e of G.edges()
		setLabel(e, UNEXPLORED)
	for all v of G.vertices()
		if getLabel(v) = UNEXPLORED
			preComponentVisit(G, v)
			BFS(G, v)
			postComponentVisit(G, v)
	result(G)

Algorithm BFS(G, s)
	L <- new empty sequence
	L.insertLast(s)
	setLabel(s, VISITED)
	startVertexVisit(v)
	while !L.isEmpty() do
		v <- L.remove (L.first())
		for all e of G.incidentEdges(v) do
			if getLabel(e) = UNEXPLORED then
				w <- opposite(v,e)
				if getLabel(w) = UNEXPLORED then
					preDiscoveryTraversal(G, v, e, w)
					setLabel(e, DISCOVERY)
					setLabel(w, VISITED)
					L.insertLast(w)
					postDiscoveryTraversal(G, v, e, w)
				else
					setLabel(e, CROSS)
					backTraversal(G, v, e, w)
	finishVertexVisit(G, v)
13.2(b)
Algorithm findPath(G, u, v)
	S <-new empty stack {S is a subclass field}
	z<-v  {z is a subclass field & is the target vertex}
	BFS(G,u)
	return(path)
	
Algorithm startVertexVisit(v)
	S.push(v)
Algorithm preDiscoveryTraversal(G,v,e,w)
	if !pathFound then
		S.push(e)
		S.push(w)
Algorithm postDiscoveryTraversal(G,v,e,w)
	if w = z then{z is a subclass varibale and target}
		pathFound = true
		
Algorithm finishVertexVisit(G, v)
	if !pathFound then 
		return no_such_path
	return S.elements()
	
13.2(c)
Algorithm startVertexVisit(v)
	if !cycleFound then
		S.push(v)
Algorithm preDiscoveryTraversal(G,v,e,w)
	if !cycleFound then
		S.push(e)
		S.push(w)
Algorithm backTraversal(G, v, e, w)
	if !cycleFound then
		cycle<-new empty sequence
		cycle.insertLast(w)
		while o != w do
			o<-S.pop()
			cycle.insertLast(o)
		cycleFound <- true
Algorithm finishVertexVisit(G, v)
	while !S.empty()
		S.pop()
	if !cycleFound then
		return no_cycle_found
	else
		return cycle
13.2(d)
No.
Reason:DFS goes into the deep of a node and there is no guarantee that that path will be the minimum number of edges and it is hard to find minimum number of edges during backtracking.

=======================================
13(1)
Algorithm initResult(G)
	S<- new Empty Sequence
Algorithm preComponentVisit(G, v)
	S.insertLast(v)	
Algorithm result(G)
	return S;
13(4)
Algorithm initResult(G)
	levelNo <- 1
Algorithm startVertexVisit(v)
	setLevel(v,levelNo){levelNo is a subclass field}
Algorithm postComponentVisit(G,v)
	levelNo <- levelNo + 1

	==========
13(3)	
Algorithm DijkstraDistances(G, s)
	Q <-new heap-based priority queue
	initGraph(G) 
	for all v of G.vertices() do
		if v = s
			setDistance(v, 0)
		else
			setDistance(v, INF)
		l<-Q.insert(getDistance(v), v)
		setLocator(v,l)
	startVertexVisit(G,s)
	while !Q.isEmpty() do
		u <- Q.removeMin()
		for all e of G.incidentEdges(u)
			{ relax edge e }
			z <- G.opposite(u,e)
			r <- getDistance(u) + weight(e)
			if r < getDistance(z) then
				preUpdate()
				setDistance(z,r)
				Q.replaceKey(getLocator(z),r)
				postUpdate(G,u,e,z)
	finishVertexVisit(G,s)		
=========
Algorithm findPath(G, u, v)
	S <-new empty stack {S is a subclass field}
	z<-v  {z is a subclass field & is the target vertex}
	DijkstraDistances(G,u)
	return(path)
Algorithm startVertexVisit(G,s)
	setParent(s,NULL)
Algorithm postUpdate(G,u,e,z)
	setParent(z,e)
Algorithm finishVertexVisit(G,s)
	path<-empty sequence
	u <- z{z is a subclass varibale and target}
	path.insertLast(u)
	while u != s do
		u<-getParent(u)
		path.insertLast(u)
==============

Algorithm anatjariWaterRefill(S, m)
	Input : Sequence S of water refilling place, m max distance for one bottle
	Output : Sequence S2 as path for anatjari to cross the desert with less stops for refill possible

	Q <- new heap-based priority queue
	for each x of S do
		Q.insert(x,x)
	t<-0	
	while !Q.isEmpty() do 
		t <- t + Q.removeMin()
		if t + Q.peekMin() < m then
			S2.insertElement(t)
		else
			S2.insertElement(temp)
			temp <-0
	return S2
============
Algorithm anatjariWaterRefill(G, k, s)
	Input : Graph G of map for water refilling place, k max distance for one bottle, s as anitjari's starting vertices
	Output : Sequence S2 as path for anatjari to cross the desert with less stops for refill possible
	Q <- new heap-based priority queue
	for each v on G.vertices() do
		if v = s then
			Q.insert(s,v)
		else
			Q.insert(v, v)
	while !Q.isEmpty() then
		t <- Q.removeMin()
		currWeight <- 0
		for each e on G.incidentEdges(vTemp) do
			if weight(e) < k and weight(e) > currWeight then
				currWeight <- weight(e)
			QQ.removeItem(vTemp)
			S2.insertElement(vTemp)
	return S2
		

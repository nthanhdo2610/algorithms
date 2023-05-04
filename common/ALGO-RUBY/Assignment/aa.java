Let the (S, min, max) be an instance of Subset Sum. The transformation
would use the following algorithm:
Algorithm reduceSSto0-1K(S, min, max)
	Input: a Sequence S of numbers and the limits min and max from Subset Sum
	Output: a Sequence P of pairs (representing benefit and weight) and the
	values of w and b for 0-1 Knapsack
P ? new empty Sequence
for i ? 0 to S.size()-1 do
 val ? S.elemAtRank(i)
 P.insertLast( (val, val) )
return (P, max, min) {pairs, maximum weight, minimum benefit}

Algorithm checkSS(S,min,max,T)
	sum<- 0
	for each e of T do
		sum <- sum + e
	if sum >= min ^ sum <= max then
		return yes
	else
		return no
=============
Algorithm MST2SS(G,k)
	Input:
	Output:
	T<-MST(G)
	sum <- 0
	for each e of T.edges() do
		sum <- sum + weight(e)
	S<-new empty sequence
	S.insertLast(2)
	if sum <= k then
		return (S,2)
	return (S,1)
==============
HP2LP(G,u,v)
	Input:
	Output:
	for each e of G.edges() do
		setWeight(e,1)
	return (G,u,v,G.noOfVertices()-1)
=========
Algorithm SP2MST(G,k)
	G' <- new Graph
	u<-G'.insertVertex("u")
	v<-G'.insertVertex("v")
	e<-G'.insertEdge(u,v,2)
	p<-shortestPath(G')
	sum<- 0
	for each e of P do
		sum <- sum + weight(e)
	if sum <= k then
		return (G',2)
	else
		return (G',1)
	
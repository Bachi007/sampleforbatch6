def minNumberOfRounds(relations):
    def smallest_prime_factor(n):
        """ Return the smallest prime factor of n """
        if n % 2 == 0:
            return 2
        for i in range(3, int(n**0.5) + 1, 2):
            if n % i == 0:
                return i
        return n

    from collections import defaultdict, deque
    
    # Determine the number of members `n`
    members = set()
    for u, v in relations:
        members.add(u)
        members.add(v)
    n = len(members)
    
    k = smallest_prime_factor(n)
    
    # Build the graph
    graph = {i: [] for i in range(1, n + 1)}
    for u, v in relations:
        graph[u].append(v)
    
    # Perform topological sort and determine levels of nodes
    in_degree = [0] * (n + 1)
    for u in range(1, n + 1):
        for v in graph[u]:
            in_degree[v] += 1
    
    queue = deque([i for i in range(1, n + 1) if in_degree[i] == 0])
    levels = defaultdict(int)
    topological_order = []
    
    while queue:
        node = queue.popleft()
        topological_order.append(node)
        
        for neighbor in graph[node]:
            in_degree[neighbor] -= 1
            if in_degree[neighbor] == 0:
                queue.append(neighbor)
            levels[neighbor] = max(levels[neighbor], levels[node] + 1)
    
    # Use levels to determine the number of rounds
    rounds_by_level = defaultdict(list)
    for node in topological_order:
        rounds_by_level[levels[node]].append(node)
    
    rounds = 0
    for level in sorted(rounds_by_level.keys()):
        members = rounds_by_level[level]
        rounds += (len(members) + k - 1) // k  # Ceiling of len(members) / k
    
    return rounds

if __name__ == '__main__':
    relations_rows = int(input().strip())
    relations_columns = int(input().strip())
    
    relations = []
    
    for _ in range(relations_rows):
        relations_item = list(map(int, input().rstrip().split()))
        if len(relations_item) == 2:
            relations.append(tuple(relations_item))
    
    result = minNumberOfRounds(relations)
    
    print(str(result))

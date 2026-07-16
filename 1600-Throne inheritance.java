class ThroneInheritance {
    private String King;
    private Map<String ,List<String>>family;
    private Set<String>dead;
    public ThroneInheritance(String KingName) {
    King=KingName;
    family=new HashMap<>();
    dead=new HashSet<>();    
    }
    
    public void birth(String parentName, String childName) {
     family.putIfAbsent(parentName,new ArrayList<>())   ;
     family.get(parentName).add(childName);
    }
    
    public void death(String name) {
     dead.add(name) ;  
    }
    
    public List<String> getInheritanceOrder() {
   
    List<String>order=new ArrayList<>();
    dfs(King,order);
    return order;
   }    
    private void dfs(String person,List<String>order){
        if(!dead.contains(person)){
            order.add(person);
        }
        if(family.containsKey(person)){
            for(String child:family.get(person)){
                dfs(child,order);
            }
        }
    }}


/**
 * Your ThroneInheritance object will be instantiated and called as such:
 * ThroneInheritance obj = new ThroneInheritance(kingName);
 * obj.birth(parentName,childName);
 * obj.death(name);
 * List<String> param_3 = obj.getInheritanceOrder();
 */

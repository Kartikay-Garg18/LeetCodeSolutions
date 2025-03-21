class Solution {
    boolean[] visited;
    boolean[] canPrepare;
    private boolean prepareRecipe(int idx, String[] recipes, List<List<String>> ingredients, String[] supplies){
        if(visited[idx]){
            return false;
        }

        visited[idx] = true;
        boolean flag = true;
        for(String currentIngredient : ingredients.get(idx)){
            boolean found = false;

            for(String supply : supplies){
                if(supply.equals(currentIngredient)){
                    found = true;
                    break;
                }
            }

            if(found){
                continue;
            }

            for(int i=0; i<recipes.length; i++){
                if(recipes[i].equals(currentIngredient)){
                    if(visited[i]){
                        found = canPrepare[i];
                    } else{
                        found = prepareRecipe(i, recipes, ingredients, supplies);
                    }
                    break;
                }
            }

            if(!found){
                flag = found;
                break;
            }
        }

        return canPrepare[idx] = flag;
    }

    public List<String> findAllRecipes(String[] recipes, List<List<String>> ingredients, String[] supplies) {

        visited = new boolean[recipes.length];
        canPrepare = new boolean[recipes.length];

        for(int i=0; i<recipes.length; i++){
            if(!visited[i]){
                prepareRecipe(i, recipes, ingredients, supplies);
            }
        }

        List<String> ans = new ArrayList<>();
        for(int i=0; i<recipes.length; i++){
            if(canPrepare[i]){
                ans.add(recipes[i]);
            }
        }

        return ans;
    }
}
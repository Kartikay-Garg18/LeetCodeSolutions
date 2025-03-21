class Solution {
    boolean[] visited;
    boolean[] canPrepare;
    List<String> ans;

    private boolean prepareRecipe(int idx, String[] recipes, List<List<String>> ingredients, String[] supplies){
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

            for(int i=0; i<recipes.length && !found; i++){
                if(recipes[i].equals(currentIngredient)){
                    if(visited[i]){
                        found = canPrepare[i];
                    } else{
                        found = prepareRecipe(i, recipes, ingredients, supplies);
                    }
                }
            }

            if(!found){
                flag = found;
                break;
            }
        }

        if(flag){
            ans.add(recipes[idx]);
        }

        return canPrepare[idx] = flag;
    }

    public List<String> findAllRecipes(String[] recipes, List<List<String>> ingredients, String[] supplies) {

        visited = new boolean[recipes.length];
        canPrepare = new boolean[recipes.length];
        ans = new ArrayList<>();

        for(int i=0; i<recipes.length; i++){
            if(!visited[i]){
                prepareRecipe(i, recipes, ingredients, supplies);
            }
        }

        return ans;
    }
}
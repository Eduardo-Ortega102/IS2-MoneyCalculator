package moneycalculator.UI;

public interface ActionFactory<Entity> {

    public Entity createAction(String action);
    
}

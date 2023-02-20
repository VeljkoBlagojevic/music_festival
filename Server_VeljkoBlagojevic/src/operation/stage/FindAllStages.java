/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package operation.stage;

import domain.Stage;
import exception.StageNotFoundException;
import java.util.ArrayList;
import java.util.List;
import operation.AbstractGenericOperation;
import operation.FetchType;

/**
 *
 * @author VeljkoBlagojevic
 */
public class FindAllStages extends AbstractGenericOperation {

    private List<Stage> stages = new ArrayList<>();

    @Override
    protected void preconditions(Object param) throws Exception {
        if (!(param instanceof Stage)) {
            throw new Exception("Parameter is not a type of  User");
        }
    }

    @Override
    protected void executeOperation(Object param) throws Exception {
        stages = (List<Stage>) repository.findAll(param, FetchType.LAZY);

        if (stages.isEmpty()) {
            throw new StageNotFoundException();
        }
    }

    public List<Stage> getStages() {
        return stages;
    }

}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package operation.stage;

import domain.Stage;
import java.util.List;
import operation.AbstractGenericOperation;
import operation.FetchType;

/**
 *
 * @author VeljkoBlagojevic
 */
public class SaveStage extends AbstractGenericOperation {

    private Stage stage;

    @Override
    protected void preconditions(Object param) throws Exception {
        if (!(param instanceof Stage)) {
            throw new Exception("Prosledjeni atribut nije tipa Stage");
        }

        List<Stage> dbStages = (List<Stage>) repository.findAll(new Stage(), FetchType.LAZY);
        if (dbStages.stream().anyMatch(dbStage -> dbStage.equals(param))) {
            throw new Exception("Stage is already inserted");
        }

    }

    @Override
    protected void executeOperation(Object param) throws Exception {
        stage = (Stage) repository.save(param);
    }

    public Stage getStage() {
        return stage;
    }

}

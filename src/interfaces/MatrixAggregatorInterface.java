package interfaces;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

public interface MatrixAggregatorInterface extends Remote {

    List<List<Integer>> getResult() throws RemoteException;


}
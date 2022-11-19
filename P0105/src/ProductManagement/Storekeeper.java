/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ProductManagement;

/**
 *
 * @author 10 pro 64bit
 */
class Storekeeper {

    private int storekeeperId;
    private String storekeeperName;

    public Storekeeper() {
    }

    public Storekeeper(int storeKeeperId, String storeKeeperName) {
        this.storekeeperId = storeKeeperId;
        this.storekeeperName = storeKeeperName;
    }

    public int getStorekeeperId() {
        return storekeeperId;
    }

    public void setStorekeeperId(int storekeeperId) {
        this.storekeeperId = storekeeperId;
    }

    public String getStorekeeperName() {
        return storekeeperName;
    }

    public void setStorekeeperName(String storekeeperName) {
        this.storekeeperName = storekeeperName;
    }
}

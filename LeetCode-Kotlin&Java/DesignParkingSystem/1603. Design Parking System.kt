package DesignParkingSystem

class ParkingSystem(big: Int, medium: Int, small: Int) {

    var slot=Triple(big,medium,small)
    fun addCar(carType: Int): Boolean {
        when (carType) {
            1 -> {
                return when {
                    slot.first>0 -> {
                        slot = slot.copy(slot.first - 1, slot.second, slot.third)
                        true
                    }
                    else -> false
                }
            }
            2 -> {
                return when{
                    slot.second>0 ->{
                        slot=slot.copy(slot.first,slot.second-1,slot.third)
                        true
                    }
                    else -> false
                }
            }
            3 -> {
                return when{
                    slot.third>0 ->{
                        slot=slot.copy(slot.first,slot.second,slot.third-1)
                        true
                    }
                    else -> false
                }
            }
        }
        return true
    }

}
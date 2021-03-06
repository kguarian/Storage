public class DecTree<E> implements Dec {

    E data;
    // stored
    DecTree<E> dt0;
    DecTree<E> dt1;
    DecTree<E> dt2;
    DecTree<E> dt3;
    DecTree<E> dt4;
    DecTree<E> dt5;
    DecTree<E> dt6;
    DecTree<E> dt7;
    DecTree<E> dt8;
    DecTree<E> dt9;
    // Numerical
    DecTree<E> dtN;
    // negative
    DecTree<E> dtC;
    // child
    DecTree<E> dtD;
    // decimal
    DecTree<E> dtP;
    // dec tree parent
    DecDim<E> dvP;
    // dev pro
    double ref;
    //
    DecTree<String> tags;

    int type;
    // dev type

    /**
     * Default constructor enables specialized constructors
     */
    public DecTree() {
    }

    /**
     * The Zero Value is usually null, but if you want a null value to represent a
     * nonzero value, feel free to parametrize it here.
     * 
     * @param zeroValue customized zero/null value.
     */
    public DecTree(E element) {
        this.data = element;
    }

    public DecTree(int type) {
        this.type = type;
    }

    public E element() {
        return this.data;
    }

    /**
     * Deep Copy of parametrized DecTree<Operating Type>
     * 
     * @param base
     */
    public DecTree(DecTree<E> base) {
        this.dt0 = new DecTree<E>(base.dt0);
        this.dt1 = new DecTree<E>(base.dt1);
        this.dt2 = new DecTree<E>(base.dt2);
        this.dt3 = new DecTree<E>(base.dt3);
        this.dt4 = new DecTree<E>(base.dt4);
        this.dt5 = new DecTree<E>(base.dt5);
        this.dt6 = new DecTree<E>(base.dt6);
        this.dt7 = new DecTree<E>(base.dt7);
        this.dt8 = new DecTree<E>(base.dt8);
        this.dt9 = new DecTree<E>(base.dt9);
        this.dtN = new DecTree<E>(base.dtN);
        this.dtC = new DecTree<E>(base.dtC);
        this.dtD = new DecTree<E>(base.dtD);
        this.dtP = new DecTree<E>(base.dtP);
        this.data = base.data;
        this.type = base.type;
        this.ref = base.ref;
    }

    /**
     * helper method to create dtC Tree if dtN is null then...
     * 
     * @return this.dtC
     */
    protected DecTree<E> e_dtC() {
        if (this.dtC == null) {
            this.dtC = new DecTree<E>(-3);
            this.dtC.dtP = this;
        }
        return this.dtC;
    }

    protected DecDim<E> e_dvP() { // ensure dvP (ensure pro)
        if (this.dvP == null) {
            this.dvP = new DecDim<E>();
        }
        return this.dvP;
    }

    protected DecTree<E> pro(DecTree<E> tree) {
        if (this.dvP == null) {
            this.dvP = new DecDim<E>();
        }
        return this.dvP.base(tree);
    }

    /**
     * time-saver.
     * 
     * @param address the double value referencing the Dec holding the DecNode it
     *                will return
     * @return this.tGet(address).node
     */
    public E getData(double address) {
        return this.tGet(address).data;
    }

    public E getData() {
        return this.data;
    }

    public void setData(E element) {
        this.data = element;
    }

    /**
     * returns the tree at opTree.dt[X]
     * 
     * @param mod    = [X], N is -1, D is -10
     * @param opTree
     * @return opTree.dt[mod]
     */
    private DecTree<E> $getChildWithIdAndParent(int mod, DecTree<E> opTree) {
        if (mod == -10) {
            opTree = opTree.dtD;
        }
        if (mod == -3) {
            opTree = opTree.dtC;
        } else if (mod == -1) {
            opTree = opTree.dtN;
        } else if (mod == 0) {
            opTree = opTree.dt0;
        } else if (mod == 1) {
            opTree = opTree.dt1;
        } else if (mod == 2) {
            opTree = opTree.dt2;
        } else if (mod == 3) {
            opTree = opTree.dt3;
        } else if (mod == 4) {
            opTree = opTree.dt4;
        } else if (mod == 5) {
            opTree = opTree.dt5;
        } else if (mod == 6) {
            opTree = opTree.dt6;
        } else if (mod == 7) {
            opTree = opTree.dt7;
        } else if (mod == 8) {
            opTree = opTree.dt8;
        } else {
            opTree = opTree.dt9;
        }
        return opTree;
    }

    /**
     * returns the tree at dt[X]. Creates it first if it is null.
     * 
     * @param mod    = [X], N is -1, D is -10
     * @param opTree
     * @return opTree.dt[mod]
     */
    protected DecTree<E> $ensureChildWithIdAndParent(int mod, DecTree<E> opTree) {

        if (mod == -10) {
            if (opTree.dtD == null) {
                opTree.dtD = new DecTree<E>(mod);
            }
            opTree = opTree.dtD;
        }
        if (mod == -3) {
            if (opTree.dtC == null) {
                opTree.dtC = new DecTree<E>(mod);
            }
            opTree = opTree.dtC;
        }
        if (mod == -1) {
            if (opTree.dtN == null) {
                opTree.dtN = new DecTree<E>(mod);
            }
            opTree = opTree.dtN;
        } else if (mod == 0) {
            if (opTree.dt0 == null) {
                opTree.dt0 = new DecTree<E>(mod);
            }
            opTree = opTree.dt0;
        } else if (mod == 1) {
            if (opTree.dt1 == null) {
                opTree.dt1 = new DecTree<E>(mod);
            }
            opTree = opTree.dt1;
        } else if (mod == 2) {
            if (opTree.dt2 == null) {
                opTree.dt2 = new DecTree<E>(mod);
            }
            opTree = opTree.dt2;
        } else if (mod == 3) {
            if (opTree.dt3 == null) {
                opTree.dt3 = new DecTree<E>(mod);
            }
            opTree = opTree.dt3;
        } else if (mod == 4) {
            if (opTree.dt4 == null) {
                opTree.dt4 = new DecTree<E>(mod);
            }
            opTree = opTree.dt4;
        } else if (mod == 5) {
            if (opTree.dt5 == null) {
                opTree.dt5 = new DecTree<E>(mod);
            }
            opTree = opTree.dt5;
        } else if (mod == 6) {
            if (opTree.dt6 == null) {
                opTree.dt6 = new DecTree<E>(mod);
            }
            opTree = opTree.dt6;
        } else if (mod == 7) {
            if (opTree.dt7 == null) {
                opTree.dt7 = new DecTree<E>(mod);
            }
            opTree = opTree.dt7;
        } else if (mod == 8) {
            if (opTree.dt8 == null) {
                opTree.dt8 = new DecTree<E>(mod);
            }
            opTree = opTree.dt8;
        } else {
            if (opTree.dt9 == null) {
                opTree.dt9 = new DecTree<E>(mod);
            }
            opTree = opTree.dt9;
        }
        opTree.dtP = this;
        opTree.ref = mod;
        return opTree;
    }

    /**
     * navigates to the Dec at the address. Institutes default Decs if the necessary
     * addresses don't exist.
     * 
     * @param address
     * @return the addressed Dec
     */
    protected DecTree<E> paveTo(double address) {
        double copyID = address;
        DecTree<E> opTree = this;
        if (copyID < 0) {
            copyID *= -1;
            opTree = $ensureChildWithIdAndParent(-1, opTree);
        }
        while (copyID >= 1) {
            int mod = (int) copyID % 10;
            copyID /= 10;
            opTree = $ensureChildWithIdAndParent(mod, opTree);
        }
        opTree = $ensureChildWithIdAndParent(-10, opTree);
        while (copyID > 0) {
            copyID *= 10;
            int floorDecaID = (int) copyID;
            copyID -= floorDecaID;
            opTree = $ensureChildWithIdAndParent(floorDecaID, opTree);
        }
        return opTree;
    }

    /**
     * navigates to the Dec at the address.
     * 
     * @param address
     * @return the addressed Dec
     */
    protected DecTree<E> goGrab(double address) {
        double copyID = address;
        DecTree<E> opTree = this;
        if (copyID < 0) {
            copyID *= -1;
            opTree = $getChildWithIdAndParent(-1, opTree);
        }
        while (copyID >= 1) {
            int mod = (int) copyID % 10;
            copyID /= 10;
            opTree = $getChildWithIdAndParent(mod, opTree);
        }
        opTree = $getChildWithIdAndParent(-10, opTree);
        while (copyID > 0) {
            copyID *= 10;
            int floorDecaID = (int) copyID;
            copyID -= floorDecaID;
            opTree = $getChildWithIdAndParent(floorDecaID, opTree);
        }
        return opTree;
    }

    /**
     * places a DecNode containing the parametrized element in a decNode under the
     * addressed Dec
     * 
     * @param address
     * @param element
     * @return
     */
    public DecTree<E> add(double address, E element) {
        DecTree<E> opTree = this.paveTo(address);
        while (opTree.dtC != null) {
            opTree = opTree.dtC;
        }
        DecTree<E> retTree = opTree.e_dtC();
        retTree.data = element;
        return retTree;
    }

    public String toString() {
        // RE-IMPLEMENT: C, N, D, DIGITS
        return null;
    }

    /**
     * returns the Dec at the parametrized address
     * 
     * @param address
     * @return in description
     */
    public DecTree<E> tGet(double address) {// read dev0
        return this.goGrab(address).dtC;
    }

    public E get(double address) {
        return this.goGrab(address).dtC.data;
    }

    /**
     * replaces the Dec at the parametrized address with the parametrized tree
     * 
     * @param address
     * @param tree
     */
    public void tGet(double address, DecTree<E> tree) {
        DecTree<E> opTree = this.goGrab(address
                - (address / Math.pow(10, (int) Math.log10(address)) * (Math.pow(10, (int) Math.log10(address) - 1)))); // first//
                                                                                                                        // digit
        $getChildWithIdAndParent(0, opTree);
    }

    public void moldAfter(DecTree<E> tree) {
        this.dt0 = tree.dt0;
        this.dt1 = tree.dt1;
        this.dt2 = tree.dt2;
        this.dt3 = tree.dt3;
        this.dt4 = tree.dt4;
        this.dt5 = tree.dt5;
        this.dt6 = tree.dt6;
        this.dt7 = tree.dt7;
        this.dt8 = tree.dt8;
        this.dt9 = tree.dt9;
        this.dtN = tree.dtN;
        this.dtC = tree.dtC;
        this.dtD = tree.dtD;
        this.dvP = tree.dvP;
        this.data = tree.data;
    }

    /**
     * will pop the prominent tree from the chain of children of the tree at the
     * parametrized address then substitute it with the one added subsequently
     * 
     * @param address
     */
    public void rm(double address) {// remove at dev0
        DecTree<E> opTree = this.tGet(address);
        while (opTree.dtC != null) {
            opTree.data = opTree.dtC.data;
            opTree = opTree.dtC;
        }
        opTree.data = null;
    }

    public void rmAll(double address) {
        this.tGet(address).dt0 = null;
    }

    /**
     * removes the whole chain of entries deposited at the parametrized address
     * 
     * @param address
     */
    public void rmTree(double address) {
        DecTree<E> opTree = this.goGrab(address).dtP;
        byte firstDigit = (byte) (address / Math.pow(10, Math.log10(address)) + Double.MIN_VALUE);

        // gets first digit of address, should account for floating point errors too
        // except those within minval of specified address
        // Extension cord?
        // (constant).
        // also byte's smaller than double XD
        opTree = $getChildWithIdAndParent(firstDigit, opTree);
        opTree = new DecTree<E>(firstDigit);
    }

    public double getAddress() {
        String addressString = "";
        DecTree<E> opTree = this;
        while (opTree.dtP != null) {
            opTree = opTree.dtP;
            if (opTree.ref == -3) {
                return Double.parseDouble(addressString);
            }
            addressString = opTree.ref >= 0 ? Long.toString((long) opTree.ref)
                    : opTree.ref == -1 ? "-" : "." + addressString;
            System.out.println(addressString);
        }
        return Double.parseDouble(addressString);
    }
}

/**
 * DecDim is a Designated holder for DecTrees
 * 
 * @param <T> the E from DecTree, ideally. Will have to check use cases.
 */

class DecDim<T> implements Dec { // Dimensional extension for the dec. Stores Dec.
    DecTree<DecDim<T>> dims;
    DecTree<DecTree<T>> cat; // dimensions
    DecTree<T> base;
    private DecTree<T> lastMod;

    public DecDim() {
        cat = new DecTree<DecTree<T>>();
        dims = new DecTree<DecDim<T>>();
    }

    public DecDim(DecTree<T> tree) {
        cat = new DecTree<DecTree<T>>();
        dims = new DecTree<DecDim<T>>();
        this.base = tree;
    }

    public DecTree<DecTree<T>> add(double address, DecTree<T> tree) {
        return cat.add(address, tree);
    }

    public DecTree<T> base(DecTree<T> tree) {
        this.base = tree;
        return base;
    }

    public DecTree<T> get(double address) {
        return cat.get(address);
    }

    public DecDim<T> dGet(double address) {
        return dims.get(address);
    }

    public void rm(double address) {
        cat.rm(address);
    }

    public DecDim<T> pro(double address) {
        return dims.get(address);
    }

}

/**
 * For: Server from DecTree to compatible other class.
 * 
 * Methods: String decOut(); puts the DecTree out as a compressed string.
 * Object[] decIn(String compressedString); takes in DecTree from compressed
 * string and returns Object[]{DecTree<E>, "E"}.
 * 
 * IDEAL USE: in Runnable thread.
 */
class DecTreeRW<E> extends DecTree<E> {
    public String decOut() {
        String typeString;
        try {
            typeString = this.data.getClass().getName()+"\n";
        } catch (NullPointerException e) {
            typeString = "\n";
        }
        //order: 0,1,2,3,4,5,6,7,8,9,dtC,dtD,dtN. No dvP or dvA until I label the DecTrees.

        return null;
    }
}

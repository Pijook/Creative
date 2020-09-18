package pl.trollcraft.creative.core.wrappers;

import org.bukkit.World;
import org.bukkit.entity.Entity;

import com.comphenix.protocol.PacketType;
import com.comphenix.protocol.events.PacketContainer;
import com.comphenix.protocol.events.PacketEvent;
import com.comphenix.protocol.wrappers.WrappedChatComponent;

public class WrapperPlayServerOpenWindow extends AbstractPacket {
    public static final PacketType TYPE = PacketType.Play.Server.OPEN_WINDOW;

    public WrapperPlayServerOpenWindow() {
        super(new PacketContainer(TYPE), TYPE);
        handle.getModifier().writeDefaults();
    }

    public WrapperPlayServerOpenWindow(PacketContainer packet) {
        super(packet, TYPE);
    }

    /**
     * Retrieve Window id.
     * <p>
     * Notes: a unique id number for the window to be displayed. Notchian server
     * implementation is a counter, starting at 1.
     *
     * @return The current Window id
     */
    public int getWindowID() {
        return handle.getIntegers().read(0);
    }

    /**
     * Set Window id.
     *
     * @param value - new value.
     */
    public void setWindowID(int value) {
        handle.getIntegers().write(0, value);
    }

    /**
     * Retrieve Inventory Type.
     * <p>
     * Notes: the window type to use for display. Check below
     *
     * @return The current Inventory Type
     */
    public int getInventoryType() {
        return handle.getIntegers().read(2);
    }

    /**
     * Set Inventory Type.
     *
     * @param value - new value.
     */
    public void setInventoryType(int value) {
        handle.getIntegers().write(2, value);
    }

    /**
     * Retrieve Window title.
     * <p>
     * Notes: the title of the window.
     *
     * @return The current Window title
     */
    public WrappedChatComponent getWindowTitle() {
        return handle.getChatComponents().read(0);
    }

    /**
     * Set Window title.
     *
     * @param value - new value.
     */
    public void setWindowTitle(WrappedChatComponent value) {
        handle.getChatComponents().write(0, value);
    }

    /**
     * Retrieve Number of Slots.
     * <p>
     * Notes: number of slots in the window (excluding the number of slots in
     * the player inventory).
     *
     * @return The current Number of Slots
     */
    public int getNumberOfSlots() {
        return handle.getIntegers().read(1);
    }

    /**
     * Set Number of Slots.
     *
     * @param value - new value.
     */
    public void setNumberOfSlots(int value) {
        handle.getIntegers().write(1, value);
    }

    /**
     * Retrieve Entity ID.
     * <p>
     * Notes: entity's ID
     *
     * @return The current Entity ID
     */
    public int getEntityID() {
        return handle.getIntegers().read(0);
    }

    /**
     * Set Entity ID.
     *
     * @param value - new value.
     */
    public void setEntityID(int value) {
        handle.getIntegers().write(0, value);
    }

    /**
     * Retrieve the entity of the painting that will be spawned.
     *
     * @param world - the current world of the entity.
     * @return The spawned entity.
     */
    public Entity getEntity(World world) {
        return handle.getEntityModifier(world).read(0);
    }

    /**
     * Retrieve the entity of the painting that will be spawned.
     *
     * @param event - the packet event.
     * @return The spawned entity.
     */
    public Entity getEntity(PacketEvent event) {
        return getEntity(event.getPlayer().getWorld());
    }
}
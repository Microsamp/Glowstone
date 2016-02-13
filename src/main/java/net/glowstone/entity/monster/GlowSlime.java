package net.glowstone.entity.monster;

import com.flowpowered.networking.Message;
import net.glowstone.entity.meta.MetadataIndex;
import org.bukkit.Location;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Slime;

import java.util.List;
import java.util.Random;

public class GlowSlime extends GlowMonster implements Slime {

    private boolean onGround;

    public GlowSlime(Location loc) {
        this(loc, EntityType.SLIME);
        Random r = new Random();
        byte size = 1;
        double health = 1;
        switch (r.nextInt(3)) {
            case 0:
                size = 1;
                health = 1;
                break;
            case 1:
                size = 2;
                health = 4;
                break;
            case 2:
                size = 4;
                health = 16;
                break;
        }
        setSize(size);
        setMaxHealthAndHealth(health);
    }

    protected GlowSlime(Location loc, EntityType type) {
        super(loc, type);
    }

    @Override
    public List<Message> createSpawnMessage() {
        metadata.set(MetadataIndex.SLIME_SIZE, (byte) getSize());
        return super.createSpawnMessage();
    }

    @Override
    public List<Message> createUpdateMessage() {
        return super.createUpdateMessage();
    }

    @Override
    public int getSize() {
        return metadata.getByte(MetadataIndex.SLIME_SIZE);
    }

    @Override
    public void setSize(int sz) {
        metadata.set(MetadataIndex.SLIME_SIZE, (byte) sz);
    }
}

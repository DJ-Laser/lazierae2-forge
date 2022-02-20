package com.github.almostreliable.lazierae2.core;

import com.github.almostreliable.lazierae2.core.TypeEnums.TRANSLATE_TYPE;
import com.github.almostreliable.lazierae2.util.TextUtil;
import net.minecraftforge.common.ForgeConfigSpec;
import net.minecraftforge.common.ForgeConfigSpec.Builder;
import net.minecraftforge.common.ForgeConfigSpec.DoubleValue;
import net.minecraftforge.common.ForgeConfigSpec.IntValue;
import org.apache.commons.lang3.tuple.Pair;

import static com.github.almostreliable.lazierae2.core.Constants.*;

public final class Config {

    public static final ForgeConfigSpec COMMON_SPEC;
    static final CommonConfig COMMON;

    static {
        Pair<CommonConfig, ForgeConfigSpec> commonPair = new Builder().configure(CommonConfig::new);
        COMMON_SPEC = commonPair.getRight();
        COMMON = commonPair.getLeft();
    }

    private Config() {}

    static final class MachineConfig {

        final IntValue upgradeSlots;
        final IntValue baseEnergyBuffer;
        final IntValue energyBufferAdd;
        final IntValue baseEnergyUsage;
        final DoubleValue energyUsageMulti;
        final IntValue baseProcessTime;
        final DoubleValue processTimeMulti;
        private final String id;

        private MachineConfig(
            Builder builder, String id
        ) {
            this.id = id;

            builder.push(id);
            upgradeSlots = builder.comment(
                " The number of upgrades the " + id + " can hold.",
                " By default, upgrades will speed up the machine and increase the energy buffer at the cost of a higher energy consumption."
            ).translation(machineTranslation(UPGRADE_SLOTS)).defineInRange(UPGRADE_SLOTS, 8, 0, 64);
            baseEnergyBuffer = builder
                .comment(
                    " The amount of energy the " + id + " can hold.",
                    " The energy buffer is used to store energy before it is used."
                )
                .translation(machineTranslation(ENERGY_BUFFER))
                .defineInRange(ENERGY_BUFFER, 100_000, 0, Integer.MAX_VALUE);
            energyBufferAdd = builder
                .comment(
                    " The additional amount of energy the " + id + " can hold per upgrade.",
                    " Each upgrade increases the energy buffer by this amount.",
                    " Setting this to 0 will disable the energy buffer upgrade.",
                    " Calculation: energyBuffer = baseEnergyBuffer + (installedUpgrades * energyBufferAdd)"
                )
                .translation(machineTranslation(ENERGY_BUFFER_UPGRADE))
                .defineInRange(ENERGY_BUFFER_UPGRADE, 50_000, 0, Integer.MAX_VALUE);
            baseEnergyUsage = builder.comment(
                " The base amount of energy the " + id + " uses per tick.",
                " Each recipe can overwrite this value. This is just a fallback value if a recipe does not specify an energy usage.",
                " All recipes from the mod itself have an own energy usage value and this setting won't have any effect on them.",
                " This is only useful for custom recipes e.g. for modpack makers."
            ).translation(machineTranslation(ENERGY_USAGE)).defineInRange(ENERGY_USAGE, 300, 0, Integer.MAX_VALUE);
            energyUsageMulti = builder
                .comment(
                    " The energy multiplier the " + id + " uses per tick when upgraded.",
                    " Each upgrade multiplies the energy usage by this value.",
                    " Setting this to 1 will disable the energy usage multiplier.",
                    " Lower values than 1 will decrease the energy usage, higher values will increase it.",
                    " Calculation: energyUsage = baseEnergyUsage * energyUsageMulti ^ installedUpgrades"
                )
                .translation(machineTranslation(ENERGY_USAGE_UPGRADE))
                .defineInRange(ENERGY_USAGE_UPGRADE, 1.3, 0, Double.MAX_VALUE);
            baseProcessTime = builder.comment(
                " The base processing time the " + id + " needs for a recipe.",
                " Each recipe can overwrite this value. This is just a fallback value if a recipe does not specify a processing time.",
                " All recipes from the mod itself have an own processing time value and this setting won't have any effect on them.",
                " This is only useful for custom recipes e.g. for modpack makers."
            ).translation(machineTranslation(PROCESS_TIME)).defineInRange(PROCESS_TIME, 200, 0, Integer.MAX_VALUE);
            processTimeMulti = builder
                .comment(
                    " The processing time multiplier the " + id + " uses when upgraded.",
                    " Each upgrade multiplies the processing time for a recipe by this value.",
                    " Setting this to 1 will disable the processing time multiplier.",
                    " Lower values than 1 will decrease the processing time, higher values will increase it.",
                    " Calculation: processTime = baseProcessTime * processTimeMulti ^ installedUpgrades"
                )
                .translation(machineTranslation(PROCESS_TIME_UPGRADE))
                .defineInRange(PROCESS_TIME_UPGRADE, 0.8, 0, Double.MAX_VALUE);
            builder.pop();
        }

        private String machineTranslation(String translationKey) {
            return TextUtil.translateAsString(TRANSLATE_TYPE.CONFIG, id + "." + translationKey);
        }
    }

    public static final class CommonConfig {

        public final MachineConfig aggregator;
        public final MachineConfig centrifuge;
        public final MachineConfig energizer;
        public final MachineConfig etcher;

        private CommonConfig(Builder builder) {
            builder.comment(
                "##################################################################################",
                " This section lets you configure the various values of the mod machines.         #",
                " If there is an option mentioning 'upgrades', AE2 Acceleration Cards are meant.  #",
                "##################################################################################"
            );

            aggregator = new MachineConfig(builder, AGGREGATOR_ID);
            centrifuge = new MachineConfig(builder, CENTRIFUGE_ID);
            energizer = new MachineConfig(builder, ENERGIZER_ID);
            etcher = new MachineConfig(builder, ETCHER_ID);
        }
    }
}

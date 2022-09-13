package com.almostreliable.lazierae2.core;

@SuppressWarnings({"StaticMethodOnlyUsedInOneClass", "WeakerAccess"})
public final class Constants {

    public static final String NETWORK_ID = "network";

    private Constants() {}

    public enum Blocks {
        ;
        public static final String PROCESSOR_ID = "processor";
        public static final String AGGREGATOR_ID = "aggregator";
        public static final String ETCHER_ID = "etcher";
        public static final String GRINDER_ID = "grinder";
        public static final String INFUSER_ID = "infuser";
        public static final String REQUESTER_ID = "requester";
    }

    public enum Items {
        ;
        public static final String CARB_FLUIX_DUST_ID = "carbonic_fluix_dust";
        public static final String COAL_DUST_ID = "coal_dust";
        public static final String FLUIX_STEEL_ID = "fluix_steel_ingot";
        public static final String GROWTH_CORE_ID = "growth_core";
        public static final String LOGIC_UNIT_ID = "logic_unit";
        public static final String PARALLEL_PRINTED_ID = "parallel_printed";
        public static final String PARALLEL_PROCESSOR_ID = "parallel_processor";
        public static final String RESONATING_CRYSTAL_ID = "resonating_crystal";
        public static final String RESONATING_DUST_ID = "resonating_dust";
        public static final String RESONATING_SEED_ID = "resonating_seed";
        public static final String UNIVERSAL_PRESS_ID = "universal_press";
    }

    public enum Nbt {
        ;
        public static final String INVENTORY_ID = "inventory";
        public static final String SIDE_CONFIG_ID = "side_config";
        public static final String CAPACITY_ID = "capacity";
        public static final String ENERGY_ID = "energy";
        public static final String MAX_RECEIVE = "max_receive";
        public static final String MAX_EXTRACT = "max_extract";
        public static final String AUTO_EXTRACT_ID = "auto_extract";
        public static final String PROGRESS_ID = "progress";
        public static final String PROCESS_TIME_ID = "process_time";
        public static final String RECIPE_TIME_ID = "recipe_time";
        public static final String ENERGY_COST_ID = "energy_cost";
        public static final String RECIPE_ENERGY_ID = "recipe_energy";
        public static final String UPGRADES_ID = "upgrades";
        public static final String PROGRESSION_STATES_ID = "progression_states";
        public static final String CRAFT_REQUESTS_ID = "craft_requests";
        public static final String STORAGE_MANAGER_ID = "storage_manager";
        public static final String ITEM_TYPE_ID = "item_type";
        public static final String BUFFER_AMOUNT_ID = "buffer_amount";
        public static final String PENDING_AMOUNT_ID = "pending_amount";
        public static final String KNOWN_AMOUNT_ID = "known_amount";
        public static final String SLOT_ID = "slot";
        public static final String SIZE_ID = "size";
        public static final String ITEMS_ID = "items";
        public static final String STATE_ID = "state";
        public static final String STACK_ID = "stack";
        public static final String COUNT_ID = "count";
        public static final String BATCH_ID = "batch";
    }

    public enum Recipe {
        ;
        public static final String CONDITIONS = "conditions";
        public static final String OUTPUT = "output";
        public static final String ITEM = "item";
        public static final String COUNT = "count";
        public static final String INPUT = "input";
        public static final String PROCESS_TIME = "process_time";
        public static final String ENERGY_COST = "energy_cost";
    }
}

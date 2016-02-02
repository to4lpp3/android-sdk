/*
 * Copyright 2016, Google Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.nestlabs.sdk;

import java.util.ArrayList;

/**
 * DeviceUpdate contains the state of all devices in the Nest account when a change is detected in
 * any device. A DeviceUpdate object is returned by {@link com.nestlabs.sdk.NestListener
 * .DeviceListener#onUpdate(DeviceUpdate)} when an update occurs.
 */
public final class DeviceUpdate {
    private final ArrayList<Thermostat> mThermostats;
    private final ArrayList<SmokeCOAlarm> mSmokeCOAlarms;
    private final ArrayList<Camera> mCameras;

    DeviceUpdate(ArrayList<Thermostat> thermostats, ArrayList<SmokeCOAlarm> smokeCOAlarms,
            ArrayList<Camera> cameras) {
        mThermostats = thermostats;
        mSmokeCOAlarms = smokeCOAlarms;
        mCameras = cameras;
    }

    /**
     * Returns all the {@link Thermostat} objects in the Nest account at the time of the update.
     *
     * @return all the {@link Thermostat} objects in the Nest account at the time of the update.
     */
    public final ArrayList<Thermostat> getThermostats() {
        return mThermostats;
    }

    /**
     * Returns all the {@link SmokeCOAlarm} objects in the Nest account at the time of the update.
     *
     * @return all the {@link SmokeCOAlarm} objects in the Nest account at the time of the update.
     */
    public final ArrayList<SmokeCOAlarm> getSmokeCOAlarms() {
        return mSmokeCOAlarms;
    }

    /**
     * Returns all the {@link Camera} objects in the Nest account at the time of the update.
     *
     * @return all the {@link Camera} objects in the Nest account at the time of the update.
     */
    public final ArrayList<Camera> getCameras() {
        return mCameras;
    }
}

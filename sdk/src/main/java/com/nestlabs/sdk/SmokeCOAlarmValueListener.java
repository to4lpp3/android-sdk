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

import android.support.annotation.NonNull;

import com.firebase.client.DataSnapshot;
import com.firebase.client.FirebaseError;
import com.firebase.client.ValueEventListener;

import java.util.ArrayList;

/**
 * SmokeCOAlarmValueListener accepts a {@link NestListener.SmokeCOAlarmListener} that will receive
 * {@link NestListener.SmokeCOAlarmListener#onUpdate(ArrayList)})} events when this listener
 * receives events from Nest.
 */
class SmokeCOAlarmValueListener implements ValueEventListener {

    private final NestListener.SmokeCOAlarmListener mListener;

    SmokeCOAlarmValueListener(@NonNull NestListener.SmokeCOAlarmListener listener) {
        mListener = listener;
    }

    @Override
    public void onDataChange(DataSnapshot dataSnapshot) {
        final ArrayList<SmokeCOAlarm> alarms = new ArrayList<>();

        for (DataSnapshot postSnapshot : dataSnapshot.getChildren()) {
            SmokeCOAlarm alarm = postSnapshot.getValue(SmokeCOAlarm.class);
            alarms.add(alarm);
        }
        mListener.onUpdate(alarms);
    }

    @Override
    public void onCancelled(FirebaseError firebaseError) {
        // Do nothing.
    }
}

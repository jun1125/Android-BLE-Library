/*
 * Copyright (c) 2018, Nordic Semiconductor
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without modification, are permitted provided that the following conditions are met:
 *
 * 1. Redistributions of source code must retain the above copyright notice, this list of conditions and the following disclaimer.
 *
 * 2. Redistributions in binary form must reproduce the above copyright notice, this list of conditions and the following disclaimer in the
 * documentation and/or other materials provided with the distribution.
 *
 * 3. Neither the name of the copyright holder nor the names of its contributors may be used to endorse or promote products derived from this
 * software without specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT
 * LIMITED TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT
 * HOLDER OR CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT
 * LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON
 * ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE
 * USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */

package no.nordicsemi.android.ble;

import android.bluetooth.BluetoothDevice;
import android.support.annotation.NonNull;

import no.nordicsemi.android.ble.callback.FailCallback;
import no.nordicsemi.android.ble.callback.SuccessCallback;

@SuppressWarnings("WeakerAccess")
public class ConnectRequest extends Request {

	ConnectRequest(@NonNull final Type type) {
		super(type);
		enqueued = true;
	}

	@NonNull
	@Override
	ConnectRequest setManager(@NonNull final BleManager manager) {
		super.setManager(manager);
		return this;
	}

	/**
	 * Use to add a completion callback. The callback will be invoked when the operation has
	 * finished successfully unless {@link #await(int)} or its variant was used, in which case this
	 * callback will be ignored.
	 * <p>
	 * The done callback will also be called when one or more of initialization requests has
	 * failed due to a reason other than disconnect event. This is because
	 * {@link BleManagerCallbacks#onDeviceReady(BluetoothDevice)} is called no matter
	 * if the requests succeeded, or not. Set failure callbacks to initialization requests
	 * to get information about failures.
	 *
	 * @param callback the callback.
	 * @return The request.
	 */
	@NonNull
	@Override
	public ConnectRequest done(@NonNull final SuccessCallback callback) {
		super.done(callback);
		return this;
	}

	@NonNull
	@Override
	public ConnectRequest fail(@NonNull final FailCallback callback) {
		super.fail(callback);
		return this;
	}
}

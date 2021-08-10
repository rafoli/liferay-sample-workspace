/**
 * File main App.
*/

import React from 'react';

import Samples from './modules/Sample/index'

export default function App() {
	return (
		<>
			<Samples />
			<div className="container">
				<div className="sheet">
					<div className="sheet-header">
					<h2 className="sheet-title">Clay</h2>
					<div className="sheet-text">Experiment Clay components!</div>
					</div>
					<div className="sheet-section">{/** Add components here */}</div>
				</div>
			</div>
		</>
	)
}
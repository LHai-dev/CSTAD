import React from 'react'
import Button from 'react-bootstrap/Button';

export default function Feedback() {
  return (
    <div>
            <from>
            <textarea placeholder='write your Feedback' className='feeedm'></textarea>
                
            </from>
            <Button variant="primary">submit</Button>{' '}
      <Button variant="secondary">Cencel</Button>{' '}
    </div>
  )
}

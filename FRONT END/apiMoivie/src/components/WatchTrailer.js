import React, { useState } from 'react';
import Button from 'react-bootstrap/Button';
import Modal from 'react-bootstrap/Modal';

function WatchTrailer({embedKey}) {
    const [show, setShow] = useState(false);
    const handleClose = () => setShow(false);
    const handleShow = () => setShow(true);


    return (
        <>
            <Button variant="dark" size="sm" onClick={handleShow} ><i className="bi bi-eye"></i> Watch </Button>

            <Modal size="lg" show={show} onHide={handleClose}>
                <Modal.Body className="p-0">
                    <div className="ratio ratio-16x9">
                        <iframe src={`https://www.youtube.com/embed/${embedKey}?rel=0`} title="YouTube video" allowFullScreen></iframe>
                    </div>
                </Modal.Body>
            </Modal>
        </>
    );
}
export default WatchTrailer;